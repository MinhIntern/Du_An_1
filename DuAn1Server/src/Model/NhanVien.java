/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lethi
 */
public class NhanVien implements Serializable{

    private String ID;
    private String Ten;
    private Date Ngaysinh;
    private String Gioitinh;
    private String Diachi;
    private String Sdt;
    private String Email;
    private String ChucVu;
    private double Luong;
    private Date NgayTao;
    private Date NgayKetThuc;

    // Constructors
    public NhanVien() {
    }

    public NhanVien(String ID, String Ten, Date Ngaysinh, String Gioitinh, String Diachi, String Sdt,
            String Email, String ChucVu, double Luong, Date NgayTao, Date NgayKetThuc) {
        this.ID = ID;
        this.Ten = Ten;
        this.Ngaysinh = Ngaysinh;
        this.Gioitinh = Gioitinh;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
        this.Email = Email;
        this.ChucVu = ChucVu;
        this.Luong = Luong;
        this.NgayTao = NgayTao;
        this.NgayKetThuc = NgayKetThuc;
    }

    // Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public double getLuong() {
        return Luong;
    }

    public void setLuong(double Luong) {
        this.Luong = Luong;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;

    }
}
