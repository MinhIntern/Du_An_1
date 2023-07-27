/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conn.ConnectionSQL;
import Model.NhanVien;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author lethi
 */
public class NhanVienDAO implements Dao<NhanVien>{

    @Override
    public ArrayList<NhanVien> GetArrayListAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhanVien getObjectByID(String idObject) {
        NhanVien nhanVien = new NhanVien();
        
        try {
            Connection conn = ConnectionSQL.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from MonAn where ID = '"+idObject+"'");
            while (rs.next()){
                String ID =rs.getString("ID");
                String Ten = rs.getString("ten");
                Date Ngaysinh = rs.getDate("Ngaysinh");
                String Gioitinh = rs.getString("Gioitinh");
                String Diachi = rs.getString("Diachi");
                String Sdt = rs.getString("Sdt");
                String  Email = rs.getString("Email");
                String  ChucVu = rs.getString("ChucVu");
                double  Luong = rs.getDouble("Luong");
                Date  NgayTao = rs.getDate("NgayTao");
                Date  NgayKetThuc = rs.getDate("NgayKetThuc");

                nhanVien=new NhanVien(ID, Ten, Ngaysinh, Gioitinh, Diachi, Sdt, Email, ChucVu, Luong, NgayTao, NgayKetThuc);
                
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return nhanVien;
    }

    
}
