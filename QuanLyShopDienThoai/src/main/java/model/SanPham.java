package model;

public class SanPham {
    private int Masp;
    private String Tensp;
    private double Giatien;
    private int Soluong;
    private String Mota;
    private int Thesim;
    private int Bonhotrong;
    private int Ram;
    private String Anhbia;
    private int Mahang;
    private int Mahdh;

    public SanPham() {
    }

    public SanPham(int masp, String tensp, double giatien, int soluong, String mota, int thesim, int bonhotrong, int ram, String anhbia, int mahang, int mahdh) {
        Masp = masp;
        Tensp = tensp;
        Giatien = giatien;
        Soluong = soluong;
        Mota = mota;
        Thesim = thesim;
        Bonhotrong = bonhotrong;
        Ram = ram;
        Anhbia = anhbia;
        Mahang = mahang;
        Mahdh = mahdh;
    }

    public int getMasp() {
        return Masp;
    }

    public void setMasp(int masp) {
        Masp = masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public double getGiatien() {
        return Giatien;
    }

    public void setGiatien(double giatien) {
        Giatien = giatien;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int soluong) {
        Soluong = soluong;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getThesim() {
        return Thesim;
    }

    public void setThesim(int thesim) {
        Thesim = thesim;
    }

    public int getBonhotrong() {
        return Bonhotrong;
    }

    public void setBonhotrong(int bonhotrong) {
        Bonhotrong = bonhotrong;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    public String getAnhbia() {
        return Anhbia;
    }

    public void setAnhbia(String anhbia) {
        Anhbia = anhbia;
    }

    public int getMahang() {
        return Mahang;
    }

    public void setMahang(int mahang) {
        Mahang = mahang;
    }

    public int getMahdh() {
        return Mahdh;
    }

    public void setMahdh(int mahdh) {
        Mahdh = mahdh;
    }
}
