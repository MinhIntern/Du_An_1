package Method;

import Conn.ConnectionSQL;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddNhanvien {

    ConnectionSQL cn = new ConnectionSQL();

//    public void addNhanvien(String manv, String hoten, String Ngaysinh, String Gioitinh, String Email, String Diachi, boolean chucvu, String sdt, String Luong, String ngaytao) {
//        String sql = "INSERT INTO Nhanvien (ID, Ten, Ngaysinh, Gioitinh, Diachi, sdt, Email, ChucVu, Luong, NgayTao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        try {
//            PreparedStatement ps = cn.getConnection().prepareStatement(sql);
//            ps.setString(1, manv);
//            ps.setString(2, hoten);
//            ps.setString(3, Ngaysinh);
//            ps.setString(4, Gioitinh);
//            ps.setString(5, Diachi);
//            ps.setString(6, sdt);
//            ps.setString(7, Email);
//            ps.setBoolean(8, chucvu);
//            ps.setString(9, Luong);
//            ps.setString(10, ngaytao);
//            int i = ps.executeUpdate();
//            if (i == 1) {
//                JOptionPane.showMessageDialog(null, "Thêm Thành Công");
//            } else {
//                JOptionPane.showMessageDialog(null, "Thêm thất bại");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void addNhanvien(String manv, String hoten, Date Ngaysinh, String Gioitinh, String Email, String Diachi, boolean chucvu, String sdt, String Luong, Date ngaytao) {
        String sql = "INSERT INTO Nhanvien (ID, Ten, Ngaysinh, Gioitinh, Diachi, sdt, Email, ChucVu, Luong, NgayTao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = cn.getConnection().prepareStatement(sql);
            ps.setString(1, manv);
            ps.setString(2, hoten);
            ps.setString(3, sdf.format(Ngaysinh));
            ps.setString(4, Gioitinh);
            ps.setString(5, Diachi);
            ps.setString(6, sdt);
            ps.setString(7, Email);
            ps.setBoolean(8, chucvu);
            ps.setString(9, Luong);
            ps.setString(10, sdf.format(ngaytao));
            int i = ps.executeUpdate();
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Thêm Thành Công");
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
