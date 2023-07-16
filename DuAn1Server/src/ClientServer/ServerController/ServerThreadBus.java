/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientServer.ServerController;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

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

}
