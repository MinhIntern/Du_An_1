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
public class NhaCungCapCT {
    private String IDNhaCungCap;
    private String IDNguyenLieu;
    private String GhiChu;
    private Date NgayTao;

    public NhaCungCapCT() {
    }

    public NhaCungCapCT(String IDNhaCungCap, String IDNguyenLieu, String GhiChu, Date NgayTao) {
        this.IDNhaCungCap = IDNhaCungCap;
        this.IDNguyenLieu = IDNguyenLieu;
        this.GhiChu = GhiChu;
        this.NgayTao = NgayTao;
    }

    public String getIDNhaCungCap() {
        return IDNhaCungCap;
    }

    public void setIDNhaCungCap(String IDNhaCungCap) {
        this.IDNhaCungCap = IDNhaCungCap;
    }

    public String getIDNguyenLieu() {
        return IDNguyenLieu;
    }

    public void setIDNguyenLieu(String IDNguyenLieu) {
        this.IDNguyenLieu = IDNguyenLieu;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    @Override
    public String toString() {
        return "NhaCungCapCT{" + "IDNhaCungCap=" + IDNhaCungCap + ", IDNguyenLieu=" + IDNguyenLieu + ", GhiChu=" + GhiChu + ", NgayTao=" + NgayTao + '}';
    }
    
    
}
