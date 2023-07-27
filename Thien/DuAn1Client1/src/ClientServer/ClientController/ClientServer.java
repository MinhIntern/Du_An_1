/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientServer.ClientController;

import GUI.TrangQuanLyNV;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lethi
 */
public class ClientServer {
    public static HandleSocket handleSocket;
    public static TrangQuanLyNV trangQuanLyNV;

    public ClientServer() {
    }

    public static void main(String[] args) {
         try {
            handleSocket = new HandleSocket();
            handleSocket.run();
            
        } catch (Exception e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Admin chua hoat dong");
        }
         
    }
}
