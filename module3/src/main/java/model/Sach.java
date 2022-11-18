package model;

public class Sach {
    protected int MaSach;
    protected String TenSach;
    protected String TacGia;
    protected String MoTa;
    protected int SoLuong;

    public Sach() {
    }

    public Sach(int maSach, String tenSach, String tacGia, String moTa, int soLuong) {
        MaSach = maSach;
        TenSach = tenSach;
        TacGia = tacGia;
        MoTa = moTa;
        SoLuong = soLuong;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int maSach) {
        MaSach = maSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
