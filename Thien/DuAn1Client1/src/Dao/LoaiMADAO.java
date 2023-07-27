/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Conn.ConnectionSQL;
import Model.LoaiMA;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author lethi
 */
public class LoaiMADAO implements Dao<Model.LoaiMA>{

    @Override
    public ArrayList<LoaiMA> GetArrayListAll() {
        ArrayList<LoaiMA> ds = new ArrayList<>();
        try {
            Connection conn = ConnectionSQL.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("select * from LoaiMA");
            while (rs.next()){
                String ID = rs.getString("ID");
                String TEN = rs.getString("TEN");
                Date NgayTao = rs.getDate("NgayTao");
                Date NgayKetThuc = rs.getDate("NgayKetThuc");
                ds.add(new LoaiMA(ID, TEN, NgayTao, NgayKetThuc));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoaiMADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }

    @Override
    public LoaiMA getObjectByID(String x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
