/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conn.ConnectionSQL;
import Model.Account;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lethi
 */
public class AccountDAO implements Dao<Model.Account> {

    @Override
    public ArrayList<Account> GetArrayListAll() {
        ArrayList<Account> ds = new ArrayList<>();

        try {
            Connection conn = ConnectionSQL.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from Account");
            while (rs.next()) {
                int ID = rs.getInt("id");
                String idNhanVien = rs.getString("idNhanVien");
                String username = rs.getString("username");
                String passwords = rs.getString("passwords");
                ds.add(new Account(ID, idNhanVien, username, passwords));
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ds;
    }

    @Override
    public Account getObjectByID(String idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int checkLogin(String tk, String mk) {
        int check = 0;
        try {
            Connection conn = ConnectionSQL.getConnection();
            PreparedStatement prep = conn.prepareStatement("select * from Account "
                                                        + "join nhanvien on account.idnhanvien = nhanvien.id"
                                                        + " where username = ? and passwords=? and ngayketthuc is null");
            prep.setString(1, tk);
            prep.setString(2, mk);
            ResultSet rs =prep.executeQuery();
            while(rs.next()){
                check = 1;
            }
            prep.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return check;

    }

}
