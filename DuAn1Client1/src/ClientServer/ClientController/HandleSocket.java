/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientServer.ClientController;

import GUI.TrangQuanLyNV;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
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
                socket = new Socket("192.168.1.9", 7777);
            } catch (IOException ex) {
                if(ex.getMessage().equalsIgnoreCase("Connection refused: connect")){
                    JOptionPane.showMessageDialog(null, "Máy chủ chưa kết nối");
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            try {
                ClientServer.trangQuanLyNV = new TrangQuanLyNV();
                ClientServer.trangQuanLyNV.run();
                os = new ObjectOutputStream(socket.getOutputStream());
                is = new ObjectInputStream(socket.getInputStream());
                String message;
                while (flag && ((message = (String) is.readObject()) != null)) {
                    switch (message) {
                        case "Order-Succesful":
                            ClientServer.trangQuanLyNV.datmonJPanel1.orderSuccesfull();
                            break;
                    }
                }
            } catch (IOException ex) {
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

        } catch (IOException ex) {
            Logger.getLogger(HandleSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
