/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conn.ConnectionSQL;
import Model.NhanVien;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PhamNgocMinh
 */
public class NhanVienDao implements Dao<NhanVien> {

    @Override
    public ArrayList<NhanVien> GetArrayListAll() {
        ArrayList<NhanVien> NV = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from NhanVien";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String manv = rs.getString("ID");
                String tenvn = rs.getString("Ten");
                Date ngaysinh = rs.getDate("Ngaysinh");
                boolean gioitinh = rs.getBoolean("Gioitinh");
                String diachi = rs.getString("Diachi");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                BigDecimal Luong = rs.getBigDecimal("Luong");
                Date ngaytao = rs.getDate("NgayTao");
                Date ngayketthuc = rs.getDate("NgayKetThuc");
                boolean chucvu = rs.getBoolean("ChucVu");
                NhanVien nv = new NhanVien(manv, tenvn, ngaysinh, gioitinh, diachi, sdt, email, chucvu, Luong, ngaytao, ngayketthuc);
                NV.add(nv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NV;
    }

    public String CreateMaNV() {
        String ma = "";
        try {
            Connection conn = ConnectionSQL.getConnection();
            if (conn == null) {
                conn.close();
            } else {
                Statement st = conn.createStatement();
                String sql = "Select top 1 ID  from Nhanvien order by ID DESC";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    String x = rs.getString("ID").substring(2, rs.getString("ID").length());
                    ma = "NV" + String.format("%03d", Integer.parseInt(x) + 1);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ma;
    }

    public String SumNV() {
        String tong = "";
        try {
            Connection conn = ConnectionSQL.getConnection();
            if (conn == null) {
                conn.close();
            } else {
                Statement st = conn.createStatement();
                String sql = "SELECT COUNT(*) FROM NhanVien";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    int soLuongNhanVien = rs.getInt(1);
                    tong = String.valueOf(soLuongNhanVien);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tong;
    }

    public boolean dangNhap(String username, String password) {
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Account WHERE Username = ? AND Passwords = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            boolean loginSuccessful = rs.next();
            rs.close();
            ps.close();
            conn.close();
            return loginSuccessful;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean dangNhapBangEmail(String email, String password) {
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM NhanVien NV JOIN Account AC ON NV.ID = AC.IDNhanVien WHERE Email = ?");
            ps.setString(1, email); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String manv = rs.getString("ID");
                String storedPassword = rs.getString("Passwords");

                if (storedPassword != null && storedPassword.equals(password)) {
                    rs.close();
                    ps.close();
                    conn.close();
                    return true;
                }
            }
            rs.close();
            ps.close();
            conn.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public ArrayList<NhanVien> GetArrayListByID(String x) {
        ArrayList<NhanVien> NV = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM NhanVien";
            if (x.equalsIgnoreCase("Còn làm việc")) {
                sql = "SELECT * FROM NhanVien WHERE NgayKetThuc IS NULL";
            } else if (x.equalsIgnoreCase("Đã Nghỉ Việc")) {
                sql = "SELECT * FROM NhanVien WHERE NgayKetThuc IS Not NULL";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String manv = rs.getString("ID");
                String tenvn = rs.getString("Ten");
                Date ngaysinh = rs.getDate("Ngaysinh");
                boolean gioitinh = rs.getBoolean("Gioitinh");
                String diachi = rs.getString("Diachi");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                BigDecimal Luong = rs.getBigDecimal("Luong");
                Date ngaytao = rs.getDate("NgayTao");
                Date ngayketthuc = rs.getDate("NgayKetThuc");
                boolean chucvu = rs.getBoolean("ChucVu");
                NhanVien nv = new NhanVien(manv, tenvn, ngaysinh, gioitinh, diachi, sdt, email, chucvu, Luong, ngaytao, ngayketthuc);
                NV.add(nv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NV;
    }

    public int DeleteSQL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int UpdateSQL(NhanVien nv) {
        int check = 0;
        String sql = "UPDATE Nhanvien SET Ten = ?, Ngaysinh = ?, Gioitinh = ?, Diachi = ?, sdt = ?, Email = ?, ChucVu = ?, Luong = ? WHERE ID = ?";
        try {
            Connection cn = ConnectionSQL.getConnection();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nv.getHoten());
            ps.setString(2, sdf.format(nv.getNgaysinh()));
            ps.setBoolean(3, nv.isGioitinh());
            ps.setString(4, nv.getDiachi());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getEmail());
            ps.setBoolean(7, nv.isChucvu());
            ps.setBigDecimal(8, nv.getLuong());
            ps.setString(9, nv.getManv());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public int InsertSQL(NhanVien nv) {
        int check = 0;
        String sql = "INSERT INTO Nhanvien (ID, Ten, Ngaysinh, Gioitinh, Diachi, sdt, Email, ChucVu, Luong, NgayTao,NgayKetThuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, getdate(),null)";
        try {
            Connection cn = ConnectionSQL.getConnection();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, nv.getManv());
            ps.setString(2, nv.getHoten());
            ps.setString(3, sdf.format(nv.getNgaysinh()));
            ps.setBoolean(4, nv.isGioitinh());
            ps.setString(5, nv.getDiachi());
            ps.setString(6, nv.getSdt());
            ps.setString(7, nv.getEmail());
            ps.setBoolean(8, nv.isChucvu());
            ps.setBigDecimal(9, nv.getLuong());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public ArrayList<NhanVien> GetArrayListoderByDESC(String loaiSapXep, boolean tangGiam) {
        ArrayList<NhanVien> NV = new ArrayList<>();
        String tangGiams = "desc";
        if (tangGiam) {
            tangGiams = "asc";
        }
        try {
            System.out.println("da sap xep");
            Connection conn = new Conn.ConnectionSQL().getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM Nhanvien ORDER BY " + loaiSapXep + " " + tangGiams;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String manv = rs.getString("ID");
                String tenvn = rs.getString("Ten");
                Date ngaysinh = rs.getDate("Ngaysinh");
                boolean gioitinh = rs.getBoolean("Gioitinh");
                String diachi = rs.getString("Diachi");
                String sdt = rs.getString("Sdt");
                String email = rs.getString("Email");
                BigDecimal Luong = rs.getBigDecimal("Luong");
                Date ngaytao = rs.getDate("NgayTao");
                Date ngayketthuc = rs.getDate("NgayKetThuc");
                boolean chucvu = rs.getBoolean("ChucVu");
                NhanVien nv = new NhanVien(manv, tenvn, ngaysinh, gioitinh, diachi, sdt, email, chucvu, Luong, ngaytao, ngayketthuc);
                NV.add(nv);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NV;
    }

    @Override
    public int DeleteSQL(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhanVien getObjectById(String Id) {
         throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
