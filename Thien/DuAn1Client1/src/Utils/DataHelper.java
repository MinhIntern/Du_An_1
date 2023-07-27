/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author PhamNgocMinh
 *
 */
public class DataHelper {
    static Connection conn;
    static String userName = "sa";
    static String password = "01032003";
    static String url = "jdbc:sqlserver://localhost:1433" + ";"
            + "databaseName=QuanLyBanTraSua;"
            + "encrypt=false;trustServerCertificate=true;";

  
    public static ResultSet LoadData(String tableName) {    
        try {
            conn = DriverManager.getConnection(url, userName, password);
            Statement st = conn.createStatement();
            String sql = ("SELECT * from " + tableName);
            ResultSet rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
        }      
        return null;
    }
}
