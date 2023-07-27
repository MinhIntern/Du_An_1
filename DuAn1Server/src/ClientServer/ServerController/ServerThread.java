/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientServer.ServerController;

import Dao.AccountDAO;
import Dao.LoaiMADAO;
import Dao.MonAnDAO;
import Dao.NhanVienDAO;
import Model.Account;
import Model.LoaiMA;
import Model.MonAn;
import Model.NhanVien;
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
    private static String serverThreadId;
//    private boolean isClosed;
//    private String clientIP;

    public ServerThread(Socket socketOfServer) {
        this.socketOfServer = socketOfServer;
    }

    public static String getServerThreadId() {
        return serverThreadId;
    }

    @Override
    public void run() {
        try {
            is = new ObjectInputStream(socketOfServer.getInputStream());
            os = new ObjectOutputStream(socketOfServer.getOutputStream());

            while (flag) {
                String sign = (String) is.readObject();
                switch (sign) {
                    case "request-Login":
                        ArrayList<String> arr = (ArrayList<String>) is.readObject();
                        int check = new AccountDAO().checkLogin(arr.get(0), arr.get(1));
                        if (check == 1) {
                            write("login-Succesfull");
                            ArrayList<LoaiMA> dsloai = new LoaiMADAO().GetArrayListAll();
                            ArrayList<MonAn> dsMA = new MonAnDAO().GetArrayListAll();
                            NhanVien nv = new NhanVienDAO().getObjectByID(arr.get(0));
                            serverThreadId = nv.getTen();
                            write(dsloai);
                            write(dsMA);
                            write(nv);
                        } else {
                            write("login-Fail");
                        }
                        break;
                    // Yêu cầu đóng
                    case "close":
                        System.out.println(serverThreadId + " đã ngắt kết nối");
                        flag = false;
//                        System.out.println(socketOfServer.getInetAddress().getAddress() + " đã đóng.");
                        // Tạo đơn
                        break;
                    case "Create-order":
                        String x = (String) is.readObject();
                        ArrayList<Object[]> ds = (ArrayList<Object[]>) is.readObject();
                        System.out.println(ds);
                        AdminServer.testGui.createOrder(x, new ArrayList<>(ds));
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
