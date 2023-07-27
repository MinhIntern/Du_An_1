/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author PhamNgocMinh
 */
public class NguyenLieu {
    private String id;
    private String ten;
    private BigDecimal dongia;
    private Date ngayTao;
    private Date ngayKetThuc;
    private String dvt;
    private String idLoai;

    public NguyenLieu() {
    }

    
    
    public NguyenLieu(String id, String ten, BigDecimal dongia, Date ngayTao, Date ngayKetThuc, String dvt, String idLoai) {
        this.id = id;
        this.ten = ten;
        this.dongia = dongia;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
        this.dvt = dvt;
        this.idLoai = idLoai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public BigDecimal getDongia() {
        return dongia;
    }

    public void setDongia(BigDecimal dongia) {
        this.dongia = dongia;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(String idLoai) {
        this.idLoai = idLoai;
    }
    
}
