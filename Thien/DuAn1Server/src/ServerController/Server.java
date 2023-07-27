/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServerController;

import GUI.TestGUI;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lethi
 */
public class Server {

    public static volatile ServerThreadBus SocketsSever;
    public static volatile TestGUI testGui;
    public static Socket socket;
    public static int soThreadServer;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        SocketsSever = new ServerThreadBus();
        soThreadServer = 0;

        try {
            serverSocket = new ServerSocket(7777);
        } catch (Exception e) { // kiểm tra nếu socket đã tồn tại thì đóng và mở lại
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                    serverSocket = new ServerSocket(7777);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10, // corePoolSize
                100, // maximumPoolSize
                10, // thread timeout
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8) // queueCapacity
        );
        testGui = new TestGUI();
        testGui.run();
        try {
            while (true) {
                socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + " da ket noi");
                ServerThread serverThread = new ServerThread(socket);

                SocketsSever.add(serverThread);
                System.out.println("Số thread đang chạy là: " + SocketsSever.listServerThread.size());

                executor.execute(serverThread);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
