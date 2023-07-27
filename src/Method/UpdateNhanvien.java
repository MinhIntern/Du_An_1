/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Method;

import Conn.ConnectionSQL;
import java.sql.PreparedStatement;

/**
 *
 * @author PhamNgocMinh
 */
public class UpdateNhanvien {

    ConnectionSQL conn = new ConnectionSQL();

    public void UpdateNhanvien(String x) {
        try {
            if (conn.getConnection() == null) {
                conn.getConnection().close();
            } else {
                String sql = "UPDATE NhanVien SET NgayKetThuc = GetDATE() WHERE ID = ? ";
                conn.getConnection().createStatement();
                PreparedStatement ps = conn.getConnection().prepareStatement(sql);
                ps.setString(1, x);
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
