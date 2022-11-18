package model;

public class PhongTro {
    protected int MaPhongTro;
    protected String TenNguoiThueTro;
    protected String Sdt;
    protected String NgayBatDau;
    protected int HinhThucThanhToan;
    protected String GhiChu;

    public PhongTro() {
    }

    public PhongTro(int maPhongTro, String tenNguoiThueTro, String sdt, String ngayBatDau, int hinhThucThanhToan, String ghiChu) {
        MaPhongTro = maPhongTro;
        TenNguoiThueTro = tenNguoiThueTro;
        Sdt = sdt;
        NgayBatDau = ngayBatDau;
        HinhThucThanhToan = hinhThucThanhToan;
        GhiChu = ghiChu;
    }

    public PhongTro(String tenNguoiThueTro, String sdt, String ngayBatDau, int hinhThucThanhToan, String ghiChu) {
        TenNguoiThueTro = tenNguoiThueTro;
        Sdt = sdt;
        NgayBatDau = ngayBatDau;
        HinhThucThanhToan = hinhThucThanhToan;
        GhiChu = ghiChu;
    }

    public int getMaPhongTro() {
        return MaPhongTro;
    }

    public void setMaPhongTro(int maPhongTro) {
        MaPhongTro = maPhongTro;
    }

    public String getTenNguoiThueTro() {
        return TenNguoiThueTro;
    }

    public void setTenNguoiThueTro(String tenNguoiThueTro) {
        TenNguoiThueTro = tenNguoiThueTro;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    public int getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        HinhThucThanhToan = hinhThucThanhToan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }
}
