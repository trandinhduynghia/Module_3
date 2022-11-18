package model;

public class HinhThucThanhToan {
    protected int MaHinhThuc;
    protected String TenHinhThuc;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(int maHinhThuc, String tenHinhThuc) {
        MaHinhThuc = maHinhThuc;
        TenHinhThuc = tenHinhThuc;
    }

    public int getMaHinhThuc() {
        return MaHinhThuc;
    }

    public void setMaHinhThuc(int maHinhThuc) {
        MaHinhThuc = maHinhThuc;
    }

    public String getTenHinhThuc() {
        return TenHinhThuc;
    }

    public void setTenHinhThuc(String tenHinhThuc) {
        TenHinhThuc = tenHinhThuc;
    }
}
