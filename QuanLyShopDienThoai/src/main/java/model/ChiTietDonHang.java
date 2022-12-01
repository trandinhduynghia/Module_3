package model;

public class ChiTietDonHang {
    private int Madon;
    private int Masp;
    private int Soluong;
    private double Dongia;



    public ChiTietDonHang(int madon, int masp, int soluong, double dongia) {
        Madon = madon;
        Masp = masp;
        Soluong = soluong;
        Dongia = dongia;
    }

    public int getMadon() {
        return Madon;
    }

    public void setMadon(int madon) {
        Madon = madon;
    }

    public int getMasp() {
        return Masp;
    }

    public void setMasp(int masp) {
        Masp = masp;
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

    public double getThanhTien(){
        double thanhTien = 0;
        thanhTien += Soluong * Dongia;
        return thanhTien;
    }
}
