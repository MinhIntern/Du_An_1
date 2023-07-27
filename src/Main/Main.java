/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import GUI.FormDangNhap;

/**
 *
 * @author PhamNgocMinh
 */
public class Main extends Thread{
    

    public static void main(String[] args) {
        Thread th;
        th = new Thread(() -> {
            FormDangNhap bh = new FormDangNhap();
            bh.setVisible(true);
        });th.start();
    }


}
