/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.LoaiNguyenLieu;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhamNgocMinh
 */
public class LoaiNguyenLieuDao implements Dao<LoaiNguyenLieu> {

    @Override
    public ArrayList<LoaiNguyenLieu> GetArrayListAll() {
        ArrayList<LoaiNguyenLieu> loaiNguyenLieuList = new ArrayList<>();
        try {
            Connection conn = new Conn.ConnectionSQL().getConnection();

            String sql = "SELECT * FROM LoaiNguyenLieu";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String ten = rs.getString("TEN");
                Date ngayTao = rs.getDate("NgayTao");
                Date ngayKetThuc = rs.getDate("NgayKetThuc");
                LoaiNguyenLieu loaiNguyenLieu = new LoaiNguyenLieu(id, ten, ngayTao, ngayKetThuc);
                loaiNguyenLieuList.add(loaiNguyenLieu);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loaiNguyenLieuList;
    }

    @Override
    public ArrayList<LoaiNguyenLieu> GetArrayListoderByDESC(String kieusapxep, boolean tangGiam) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LoaiNguyenLieu getObjectById(String Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int DeleteSQL(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int UpdateSQL(LoaiNguyenLieu ObObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int InsertSQL(LoaiNguyenLieu Object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
