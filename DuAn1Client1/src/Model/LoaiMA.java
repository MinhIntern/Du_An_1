/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author lethi
 */
public class LoaiMA implements Serializable{

    private String ID;
    private String TEN;
    private Date NgayTao;
    private Date NgayKetThuc;

    public LoaiMA() {
    }

    public LoaiMA(String ID, String TEN, Date NgayTao, Date NgayKetThuc) {
        this.ID = ID;
        this.TEN = TEN;
        this.NgayTao = NgayTao;
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
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
