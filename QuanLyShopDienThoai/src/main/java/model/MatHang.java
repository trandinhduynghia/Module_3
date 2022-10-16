package model;

public class MatHang {
    private SanPham Sanpham;
    private int Soluong;
    private double Dongia;

    public MatHang() {
    }

    public MatHang(SanPham sanpham, int soluong, double dongia) {
        Sanpham = sanpham;
        Soluong = soluong;
        Dongia = dongia;
    }

    public SanPham getSanpham() {
        return Sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        Sanpham = sanpham;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double dongia) {
        Dongia = dongia;
    }
}
