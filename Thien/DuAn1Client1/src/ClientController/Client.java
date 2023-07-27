/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClientController;

import GUI.*;
import Model.NhanVien;
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
public class Client {
    public enum Gui{TRANGQUANLYNV,
                    FORMDANGNHAP,
                    }
    
    public static HandleSocket handleSocket;
    public static NhanVien nhanVien;
    public static TrangQuanLyNV trangQuanLyNV;
    public static FormDangNhap formDangNhap;
    public static String clientID;
    public Client() {
    }

    public static void close() {
        System.exit(0);
    }

    public static void View(Gui gui) {
        switch (gui) {
            case FORMDANGNHAP:
                formDangNhap = new FormDangNhap();
                formDangNhap.setVisible(true);
                break;
            case TRANGQUANLYNV:
                trangQuanLyNV = new TrangQuanLyNV();
                trangQuanLyNV.setVisible(true);
                break;
                
        }
    }
    
    public static void closeGui(Gui gui){
        switch (gui) {
            case FORMDANGNHAP:
                formDangNhap.dispose();
                break;
            case TRANGQUANLYNV:
                trangQuanLyNV.dispose();
                break;
        }
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
