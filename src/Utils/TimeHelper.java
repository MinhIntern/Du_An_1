package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class TimeHelper {
    public static void showClock(JLabel lblClock) {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("hh:mm:ss");
        
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
                        Thread.sleep(1000);
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
