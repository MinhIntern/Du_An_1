/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author PhamNgocMinh
 */
public class NhaCungCap {
    private String ID;
    private String Ten;
    private String DiaChi;
    private String GhiChu;
    private String Email;
    private Date Ngaytao;
    private Date NgayKetThuc;

    
    public NhaCungCap() {}

    public NhaCungCap(String ID, String Ten, String DiaChi, String GhiChu, String Email, Date Ngaytao, Date NgayKetThuc) {
        this.ID = ID;
        this.Ten = Ten;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
        this.Email = Email;
        this.Ngaytao = Ngaytao;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getNgaytao() {
        return Ngaytao;
    }

    public void setNgaytao(Date Ngaytao) {
        this.Ngaytao = Ngaytao;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }
}
