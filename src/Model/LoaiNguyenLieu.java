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
public class LoaiNguyenLieu {

    private String id;
    private String ten;
    private Date ngayTao;
    private Date ngayKetThuc;

    public LoaiNguyenLieu() {
    }

    
    public LoaiNguyenLieu(String id, String ten, Date ngayTao, Date ngayKetThuc) {
        this.id = id;
        this.ten = ten;
        this.ngayTao = ngayTao;
        this.ngayKetThuc = ngayKetThuc;
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

    
}

