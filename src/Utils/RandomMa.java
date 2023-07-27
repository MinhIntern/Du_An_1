/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.Random;

/**
 *
 * @author PhamNgocMinh
 */
public class RandomMa {
    public static String generateRandomCode() {
       
        int codeLength = 5;
      
        String validChars = "0123456789";

       
        Random random = new Random();

      
        StringBuilder codeBuilder = new StringBuilder();

      
        for (int i = 0; i < codeLength; i++) {
           
            char randomChar = validChars.charAt(random.nextInt(validChars.length()));

          
            codeBuilder.append(randomChar);
        }

        return codeBuilder.toString();
    }

    public static void main(String[] args) {
        String randomCode = generateRandomCode();
        System.out.println("Mã ngẫu nhiên: " + randomCode);
    }
}
