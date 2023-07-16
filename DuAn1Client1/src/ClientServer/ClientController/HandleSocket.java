/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientServer.ClientController;

import static ClientServer.ClientController.ClientServer.trangQuanLyNV;
import GUI.TrangQuanLyNV;
import Model.LoaiMA;
import Model.MonAn;
import Model.NhanVien;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lethi
 */
public class HandleSocket implements Runnable {

    private Socket socket;
    private static ObjectOutputStream os;
    private ObjectInputStream is;
    boolean flag = true;

    @Override
    public void run() {
        while (true) {
            try {
                socket = new Socket("192.168.1.209", 7777);
            } catch (IOException ex) {
                if (ex.getMessage().equalsIgnoreCase("Connection refused: connect")) {
                    JOptionPane.showMessageDialog(null, "Máy chủ chưa kết nối");
                    Thread.currentThread().interrupt();
                    break;
                }
                ex.printStackTrace();
            }
            try {
                os = new ObjectOutputStream(socket.getOutputStream());
                is = new ObjectInputStream(socket.getInputStream());
                login();
                String message;
                while (flag && ((message = (String) is.readObject()) != null)) {
                    switch (message) {
                        case "Order-Succesful":
                            ClientServer.trangQuanLyNV.datmonJPanel1.orderSuccesfull();
                            break;
                        case "login-Succesfull":
                            ArrayList<LoaiMA> dsLoaiMA = (ArrayList<LoaiMA>) is.readObject();
                            ArrayList<MonAn> dsMA = (ArrayList<MonAn>) is.readObject();
                            NhanVien nv = (NhanVien) is.readObject();
                            ClientServer.trangQuanLyNV = new TrangQuanLyNV();
                            ClientServer.trangQuanLyNV.setupDatMonJpanel(dsMA, dsLoaiMA,nv);
                            ClientServer.trangQuanLyNV.setVisible(true);
                            break;
                        case"login-Fail":
                            System.out.println("Sai tk hoac mk");
                            break;
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                if (ex.getMessage().equalsIgnoreCase("Connection reset")) {
                    ClientServer.trangQuanLyNV.failConection();
                } else {
                    flag = false;
                    Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void write(Object x) {
        try {
            os.writeObject(x);
            os.flush();
            os.reset();

        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tk:");
        String tk = sc.nextLine();
        System.out.println("Nhập mk:");
        String mk = sc.nextLine();
        write("request-Login");
        ArrayList<String> o = new ArrayList<>();
        o.add(tk);
        o.add(mk);
        write(o);
    }

}
