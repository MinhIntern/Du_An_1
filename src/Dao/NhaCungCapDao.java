/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conn.ConnectionSQL;
import Model.KhachHang;
import Model.LoaiNguyenLieu;
import Model.NhaCungCap;
import Model.NhanVien;
import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PhamNgocMinh
 */
public class NhaCungCapDao implements Dao<NhaCungCap> {

    @Override
    public ArrayList<NhaCungCap> GetArrayListAll() {
        ArrayList<NhaCungCap> NCC = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from  NhaCungCap";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String mancc = rs.getString("ID");
                String tenncc = rs.getString("Ten");
                String Diachi = rs.getString("DiaChi");
                String GhiChu = rs.getString("GhiChu");
                String email = rs.getString("Email");
                Date ngaytao = rs.getDate("NgayTao");
                Date ngayketthuc = rs.getDate("NgayKetThuc");
                NhaCungCap ncc = new NhaCungCap(mancc, tenncc, Diachi, GhiChu, email, ngaytao, ngayketthuc);
                NCC.add(ncc);
            }
        } catch (Exception e) {
        }
        return NCC;
    }

    public ArrayList<String> GetLoaiNguyenLieuByNhaCungCap(String idNhaCungCap) {
        ArrayList<String> loaiNguyenLieuList = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            String sql = "SELECT * From LoaiNguyenLieu Where ID NhaCungCap = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idNhaCungCap);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tenLoaiNguyenLieu = rs.getString("TEN");
                loaiNguyenLieuList.add(tenLoaiNguyenLieu);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loaiNguyenLieuList;
    }

    @Override
    public int DeleteSQL(String x) {
        int check = 0;
        ConnectionSQL conn = new ConnectionSQL();
        try {
            if (conn.getConnection() == null) {
                conn.getConnection().close();
            } else {
                String sql = "UPDATE NhaCungCap SET NgayKetThuc = GetDATE() WHERE ID = ? ";
                conn.getConnection().createStatement();
                PreparedStatement ps = conn.getConnection().prepareStatement(sql);
                ps.setString(1, x);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    // Phương thức "GetArrayListByID(String x)":
    public ArrayList<NhaCungCap> GetArrayListByID(String x) {
        ArrayList<NhaCungCap> NCC = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM NhaCungCap";
            if (x.equalsIgnoreCase("Còn Hoạt Động")) {
                sql = "SELECT * FROM NhaCungCap WHERE NgayKetThuc IS NULL";
            }
            if (x.equalsIgnoreCase("Ngưng Hoạt Động")) {
                sql = "SELECT * FROM NhaCungCap WHERE NgayKetThuc IS NOT NULL";
            }
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String mancc = rs.getString("ID");
                String tenncc = rs.getString("Ten");
                String Diachi = rs.getString("DiaChi");
                String GhiChu = rs.getString("GhiChu");
                String email = rs.getString("Email");
                Date ngaytao = rs.getDate("NgayTao");
                Date ngayketthuc = rs.getDate("NgayKetThuc");
                NhaCungCap ncc = new NhaCungCap(mancc, tenncc, Diachi, GhiChu, email, ngaytao, ngayketthuc);
                NCC.add(ncc);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NCC;
    }

    public ArrayList<NhaCungCap> GetArrayListByTenNCC(String x) {
        ArrayList<NhaCungCap> NCC = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM NhaCungCap WHERE Ten LIKE N'%" + x + "%'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String mancc = rs.getString("ID");
                String tenncc = rs.getString("Ten");
                String Diachi = rs.getString("DiaChi");
                String GhiChu = rs.getString("GhiChu");
                String email = rs.getString("Email");
                Date ngaytao = rs.getDate("NgayTao");
                Date ngayketthuc = rs.getDate("NgayKetThuc");
                NhaCungCap ncc = new NhaCungCap(mancc, tenncc, Diachi, GhiChu, email, ngaytao, ngayketthuc);
                NCC.add(ncc);
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return NCC;
    }

    @Override
    public int InsertSQL(NhaCungCap ncc) {
        int check = 0;
        String sql = "INSERT INTO NhaCungCap (ID, Ten, DiaChi, GhiChu, Email, NgayTao, NgayKetThuc) VALUES (?, ?, ?, ?, ?, getdate(),null)";
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps = conn.prepareStatement(sql);
            ps.setString(1, ncc.getID());
            ps.setString(2, ncc.getTen());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getGhiChu());
            ps.setString(5, ncc.getEmail());
            ps.setString(6, sdf.format(ncc.getNgaytao()));
            ps.setString(7, sdf.format(ncc.getNgayKetThuc()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }

    @Override
    public int UpdateSQL(NhaCungCap ncc) {
        int check = 0;
        String sql = "UPDATE ";
        try {
            Connection cn = ConnectionSQL.getConnection();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = cn.prepareStatement(sql);

            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public NhaCungCap getObjectById(String Id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<NhaCungCap> GetArrayListoderByDESC(String kieusapxep, boolean tangGiam
    ) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
