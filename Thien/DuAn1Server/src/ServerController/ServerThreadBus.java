/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerController;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lethi
 */
public class ServerThreadBus {

    public static ArrayList<ServerThread> listServerThread;

    public ServerThreadBus() {
        listServerThread = new ArrayList<>();
    }

    public void add(ServerThread socket) {
        listServerThread.add(socket);
    }

    public void remove(String idSeverThread) {
        for (ServerThread s : listServerThread) {
            if(s.getServerThreadId().equalsIgnoreCase(idSeverThread)){
                listServerThread.remove(s);
            }
        }
    }
    public ServerThread getServerThread(String clientID){
        ServerThread sv = null;
        for (ServerThread s : listServerThread) {
            if(s.getServerThreadId().equalsIgnoreCase(clientID)){
                sv = s;
            }
        }
        return sv;
    }
    
    public void messageByServerThread(String clientID,String sign,Map<String, ArrayList<?>> map){
        System.out.println(clientID + " Đang trả lời");
        for (ServerThread serverThread : listServerThread) {
            if(serverThread.getServerThreadId().equalsIgnoreCase(clientID)){
                System.out.println("đang lặp ở id là: "+ serverThread.getServerThreadId());
                serverThread.write(sign, map);
            }
        }
    }

}
