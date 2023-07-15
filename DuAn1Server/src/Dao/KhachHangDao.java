/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.KhachHang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhamNgocMinh
 */
public class KhachHangDao implements Dao<KhachHang> {

    @Override
    public ArrayList<KhachHang> GetArrayListAll() {
        ArrayList<KhachHang> KH = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from KhachHang";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KH.add(new KhachHang(rs.getString("ID"),
                         rs.getString("TEN"),
                         rs.getString("SDT"),
                         rs.getString("Ngaytao"),
                         rs.getString("LastActive"),
                         rs.getString("IDNguoiTao")
                ));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KH;
    }

    public ArrayList<KhachHang> GetArrayListByTenSP(String x) {
        ArrayList<KhachHang> KH = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from Nhanvien where Hoten like N'%" + x + "%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                KH.add(new KhachHang(rs.getString("ID"),
                        rs.getString("TEN"),
                        rs.getString("SDT"),
                        rs.getString("Ngaytao"),
                        rs.getString("LastActive"),
                        rs.getString("IDNguoiTao")));    
            };
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return KH;
    }
    
    
      public String CreateKH() {
        String ma = "";
        try {
           Connection conn = new Conn.ConnectionSQL().getConnection();
            if (conn == null) {
                conn.close();
            } else {
                Statement st = conn.createStatement();
                String sql = "Select top 1 ID from KhachHang order by ID DESC ";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    String x = rs.getString("ID").substring(2, rs.getString("ID").length() );
                    ma = "KH" + String.format("%03d",Integer.parseInt(x) + 1);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ma;
    }

    @Override
    public KhachHang getObjectByID(String idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
