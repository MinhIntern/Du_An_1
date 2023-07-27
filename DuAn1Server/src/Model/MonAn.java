package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author lethi
 */
public class MonAn implements Serializable {

    private String ID;
    private String Ten;
    private String Mota;
    private String Donvitinh;
    private BigDecimal Dongia;
    private int Soluong;
    private Date Ngaytao;
    private Date Ngayketthuc;
    private String IDloai;

    public MonAn(String ID, String Ten, String Mota, String Donvitinh, BigDecimal Dongia, int Soluong, Date Ngaytao, Date Ngayketthuc, String IDloai) {
        this.ID = ID;
        this.Ten = Ten;
        this.Mota = Mota;
        this.Donvitinh = Donvitinh;
        this.Dongia = Dongia;
        this.Soluong = Soluong;
        this.Ngaytao = Ngaytao;
        this.Ngayketthuc = Ngayketthuc;
        this.IDloai = IDloai;
    }

    public MonAn() {
    }

    
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

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public String getDonvitinh() {
        return Donvitinh;
    }

    public void setDonvitinh(String Donvitinh) {
        this.Donvitinh = Donvitinh;
    }

    public BigDecimal getDongia() {
        return Dongia;
    }

    public void setDongia(BigDecimal Dongia) {
        this.Dongia = Dongia;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public Date getNgaytao() {
        return Ngaytao;
    }

    public void setNgaytao(Date Ngaytao) {
        this.Ngaytao = Ngaytao;
    }

    public Date getNgayketthuc() {
        return Ngayketthuc;
    }

    public void setNgayketthuc(Date Ngayketthuc) {
        this.Ngayketthuc = Ngayketthuc;
    }

    public String getIDloai() {
        return IDloai;
    }

    public void setIDloai(String IDloai) {
        this.IDloai = IDloai;
    }
    
}
