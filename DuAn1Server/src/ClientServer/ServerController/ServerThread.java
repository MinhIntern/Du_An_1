/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientServer.ServerController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lethi
 */
public class ServerThread implements Runnable {
//    private tai user;
    private ServerThreadBus threadBus; 
    private Socket socketOfServer;
    private ObjectOutputStream os;
    private ObjectInputStream is;
    boolean flag = true;
//    private boolean isClosed;
//    private String clientIP;

    public ServerThread(Socket socketOfServer) {
        this.socketOfServer = socketOfServer;
    }

    @Override
    public void run() {
        try {
            is = new ObjectInputStream(socketOfServer.getInputStream());
            os = new ObjectOutputStream(socketOfServer.getOutputStream());
            String sign;
            
                while (flag&&((sign = (String) is.readObject()) != null)) {
                    switch (sign) {
                        case "close":
                            flag = false;
//                        System.out.println(socketOfServer.getInetAddress().getAddress() + " đã đóng.");
                        case "Create-order":
                            String x = (String) is.readObject();
                            ArrayList<Object[]> ds = (ArrayList<Object[]>) is.readObject();
                            AdminServer.testGui.createOrder(x, ds);
                            write("Order-Succesful");
                            break;
                    }
                }

        } catch (IOException ex) {
            flag = false;
            
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void write(Object o) {
        try {
            os.writeObject(o);
            os.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
