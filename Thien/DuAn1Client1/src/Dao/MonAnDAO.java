/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conn.ConnectionSQL;
import Model.MonAn;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lethi
 */
public class MonAnDAO implements Dao<Model.MonAn>{

    @Override
    public ArrayList<MonAn> GetArrayListAll() {
        ArrayList<MonAn> ds = new ArrayList<>();
        
        try {
            Connection conn = ConnectionSQL.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from MonAn");
            while (rs.next()){
                String ID =rs.getString("ID");
                String Ten = rs.getString("ten");
                String mota = rs.getString("Mota");
                String Donvitinh = rs.getString("Donvitinh");
                BigDecimal Dongia = rs.getBigDecimal("Dongia");
                int Soluong = rs.getInt("Soluong");
                Date Ngaytao = rs.getDate("Ngaytao");
                Date Ngayketthuc = rs.getDate("Ngayketthuc");
                String IDloai = rs.getString("IDloai");
                ds.add(new MonAn(ID, Ten, mota, Donvitinh, Dongia, Soluong, Ngaytao, Ngayketthuc, IDloai));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ds;
    }

    @Override
    public MonAn getObjectByID(String x) {
        MonAn monAn = new MonAn();
        
        try {
            Connection conn = ConnectionSQL.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from MonAn where ID = '"+x+"'");
            while (rs.next()){
                String ID =rs.getString("ID");
                String Ten = rs.getString("ten");
                String mota = rs.getString("Mota");
                String Donvitinh = rs.getString("Donvitinh");
                BigDecimal Dongia = rs.getBigDecimal("Dongia");
                int Soluong = rs.getInt("Soluong");
                Date Ngaytao = rs.getDate("Ngaytao");
                Date Ngayketthuc = rs.getDate("Ngayketthuc");
                String IDloai = rs.getString("IDloai");
                monAn=new MonAn(ID, Ten, mota, Donvitinh, Dongia, Soluong, Ngaytao, Ngayketthuc, IDloai);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MonAnDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return monAn;
    }
    
}
