/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author PhamNgocMinh
 */
public class DateHelper {
     public static void showClock(JLabel lblClock) {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("dd/MM/yyyy");
        
        Runnable rClock = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    //lay thoi diem hien tai
                    Date now = new Date();
                    //chuyen now sang String
                    String time = df.format(now);
                    lblClock.setText(time);            
                    try {
                        //cho 1s
                        Thread.sleep(86400000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };      
        Thread tClock = new Thread(rClock);
        tClock.start();
    }
}
