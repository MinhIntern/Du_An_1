/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientController;

import static ClientController.Client.trangQuanLyNV;
import GUI.FormDangNhap;
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
import java.util.HashMap;
import java.util.Map;
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
    public static ObjectOutputStream os;
    private ObjectInputStream is;
    boolean flag = true;
    private Model.NhanVien nhanVien;

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    @Override
    public void run() {
            try {
                socket = new Socket("localhost", 7777);
                System.out.println("Tao socket");
            } catch (IOException ex) {
                if (ex.getMessage().equalsIgnoreCase("Connection refused: connect")) {
                    JOptionPane.showMessageDialog(null, "Máy chủ chưa kết nối");
                    Thread.currentThread().interrupt();
                }
                ex.printStackTrace();
            }
            Client.View(Client.Gui.FORMDANGNHAP);
            try {
                os = new ObjectOutputStream(socket.getOutputStream());
                is = new ObjectInputStream(socket.getInputStream());
                Map<String, ArrayList<?>> message;
                while (flag) {
                    message = (Map<String, ArrayList<?>>) is.readObject();
                    if (message.isEmpty()) {
                        break;
                    } else {
                        String sign = message.get("sign").get(0).toString();
                        switch (sign) {
                            case "login-Succesfull":
                                ArrayList<LoaiMA> dsLoaiMA = (ArrayList<LoaiMA>) message.get("dsloai");
                                ArrayList<MonAn> dsMA = (ArrayList<MonAn>) message.get("dsMA");
                                NhanVien nv = (NhanVien) message.get("nhanvien").get(0);
                                Client.clientID = message.get("client_id").get(0).toString();
                                nhanVien = nv;
                                Client.closeGui(Client.Gui.FORMDANGNHAP);
                                Client.View(Client.Gui.TRANGQUANLYNV);
                                Client.trangQuanLyNV.setTen();
                                Client.trangQuanLyNV.setupDatMonJpanel(dsMA, dsLoaiMA);
                                System.out.println(Client.clientID +" Là id của client này");
                                break;
                            case "Order-Succesful":
                                Client.trangQuanLyNV.datmonJPanel1.orderSuccesfull();
                                break;
                            case "login-Fail":
                                System.out.println("Sai tk hoac mk");
                                break;
                            case "Order-Done":
                                break;
                            case "SoBanDaChon_Send":
                                ArrayList<String> listTableSelectedAll = (ArrayList<String>) message.get("dsban");
                                System.out.println(Client.clientID+ "id của client nhận ds bàn");
                                Client.trangQuanLyNV.listTableSelectedAll = listTableSelectedAll;
                                Client.trangQuanLyNV.setChonBanJFrame();
                                
                                break;
                            case "close":
                                Client.close();

                        }
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                if (ex.getMessage().equalsIgnoreCase("Connection reset")) {
                    Client.trangQuanLyNV.failConection();
                } else {
                    flag = false;
                    Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    public static void write(String sign, Map<String, ArrayList<?>> map) {
        try {
            Map<String, ArrayList<?>> mapWrite = new HashMap<>();
            
            ArrayList<String> arrSign = new ArrayList<>();
            arrSign.add(sign);
            mapWrite.put("sign", arrSign);
            for (Map.Entry<String, ArrayList<?>> entry : map.entrySet()) {
                mapWrite.put(entry.getKey(), entry.getValue());
            }
            os.writeObject(mapWrite);
//            os.writeObject(new HashMap<>());
            os.flush();

        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
