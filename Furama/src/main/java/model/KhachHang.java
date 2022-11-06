package model;

public class KhachHang {
    protected int MaKH;
    protected int MaLoaiKhach;
    protected String HoTen;
    protected String NgaySinh;
    protected String GioiTinh;
    protected String SoCMND;
    protected String SoDT;
    protected String Email;
    protected String DiaChi;

    public KhachHang() {
    }

    public KhachHang(int maKH, int maLoaiKhach, String hoTen, String ngaySinh, String gioiTinh, String soCMND, String soDT, String email, String diaChi) {
        MaKH = maKH;
        MaLoaiKhach = maLoaiKhach;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        SoCMND = soCMND;
        SoDT = soDT;
        Email = email;
        DiaChi = diaChi;
    }

    public KhachHang(int maLoaiKhach, String hoTen, String ngaySinh, String gioiTinh, String soCMND, String soDT, String email, String diaChi) {
        MaLoaiKhach = maLoaiKhach;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        SoCMND = soCMND;
        SoDT = soDT;
        Email = email;
        DiaChi = diaChi;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public int getMaLoaiKhach() {
        return MaLoaiKhach;
    }

    public void setMaLoaiKhach(int maLoaiKhach) {
        MaLoaiKhach = maLoaiKhach;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String soCMND) {
        SoCMND = soCMND;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }
}
