/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PhamNgocMinh
 */
public class ConnectionSQL {
    static String userName = "sa";
    static String password = "1234";
    static String url = "jdbc:sqlserver://localhost:1433" + ";"
            + "databaseName= QlyDA1;" + "encrypt=true;trustServerCertificate=true;";

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
}
