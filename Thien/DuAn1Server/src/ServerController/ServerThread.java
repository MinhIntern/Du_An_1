package ServerController;

import Dao.AccountDAO;
import Dao.LoaiMADAO;
import Dao.MonAnDAO;
import Model.LoaiMA;
import Model.MonAn;
import Model.NhanVien;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lethi
 */
public class ServerThread implements Runnable {
//    private tai user;

    private NhanVien nv;
    private static Socket socketOfServer;
    private static ObjectOutputStream os;
    private static ObjectInputStream is;
    boolean flag = true;
    private String serverThreadId;
//    private boolean isClosed;
//    private String clientIP;

    public ServerThread(Socket socketOfServer) {
        this.socketOfServer = socketOfServer;
    }

    public String getServerThreadId() {
        return serverThreadId;
    }

    public void setServerThreadId(String serverThreadId) {
        this.serverThreadId = serverThreadId;
    }

    @Override
    public void run() {
        for (ServerThread s : Server.SocketsSever.listServerThread) {
            System.out.println("Có serverthread mang id: "+s.getServerThreadId());
        }

        try {
            is = new ObjectInputStream(socketOfServer.getInputStream());
            os = new ObjectOutputStream(socketOfServer.getOutputStream());

            Map<String, ArrayList<?>> message;
            while (flag) {
                message = (Map<String, ArrayList<?>>) is.readObject();
                if (message.isEmpty()) {
                    break;
                } else {System.out.println("thienlee");
                    switch (message.get("sign").get(0).toString()) {
                        
                            
                        case "request-Login":
                            ArrayList<String> arrAcount = (ArrayList<String>) message.get("Account");
                            nv = new AccountDAO().checkLogin(arrAcount.get(0), arrAcount.get(1));
                            System.out.println(nv.getTen() + " yêu cầu đăng nhâp");
                            serverThreadId = nv.getID();
                            if (nv != null) {
                                ArrayList<LoaiMA> dsloai = new LoaiMADAO().GetArrayListAll();
                                ArrayList<MonAn> dsMA = new MonAnDAO().GetArrayListAll();
                                ArrayList<NhanVien> arrnv = new ArrayList<>();
                                ArrayList<String> arrid = new ArrayList<>();
                                arrid.add(serverThreadId);
                                arrnv.add(nv);
                                Map< String, ArrayList<?>> map = new HashMap<>();
                                map.put("dsMA", dsMA);
                                map.put("dsloai", dsloai);
                                map.put("nhanvien", arrnv);
                                map.put("client_id", arrid);
                                write("login-Succesfull", map);
                            } else {
                                write("login-Fail", new HashMap<>());
                            }
                            break;
                        // Yêu cầu đóng
                        case "close":
                            System.out.println(nv.getTen()+  " đã ngắt kết nối");
                            Server.SocketsSever.remove(serverThreadId);
                            // Tạo đơn
                            break;
                        case "Create-order":
                            Object[] table = (Object[]) message.get("table").get(0);
                            ArrayList<Object[]> ds = (ArrayList<Object[]>) message.get("dsKhachChon");
                            Server.testGui.createOrder(table, new ArrayList<>(ds));
                            break;
                        case "SoBanDaChon_Request":
                            String clientid = (String) message.get("idclient").get(0);
                            ServerThread sv = Server.SocketsSever.getServerThread(clientid);
                            
                            Map<String,ArrayList<?>> maparr = new HashMap<>();
                            maparr.put("dsban", Server.testGui.dsban);
                            System.out.println(serverThreadId+" chuyển lời");
                            Server.SocketsSever.messageByServerThread(clientid, "SoBanDaChon_Send", maparr);

                            break;
                    }
                }
            }

        } catch (IOException ex) {
            flag = false;

            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void write(String sign, Map<String, ArrayList<?>> map) {
        try {
            Map<String, ArrayList<?>> mapWrite = new HashMap<>();
            ArrayList<String> o = new ArrayList<>();
            o.add(sign);
            mapWrite.put("sign", o);
            for (Map.Entry<String, ArrayList<?>> key : map.entrySet()) {
                mapWrite.put(key.getKey(), key.getValue());
            }
            os.writeObject(mapWrite);
            os.reset();
            os.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
