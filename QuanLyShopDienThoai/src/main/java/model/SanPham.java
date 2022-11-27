package model;

public class SanPham {
    private int Masp;
    private String Tensp;
    private double Giatien;
    private int Soluong;
    private String Mota;
    private String Thesim;
    private String Bonho;
    private String Ram;
    private String Anhbia;
    private int Madanhmuc;
    private int Manguoidung;

    public SanPham() {
    }

    public SanPham(int masp, String tensp, double giatien, int soluong, String mota, String thesim, String bonho, String ram, String anhbia, int madanhmuc, int manguoidung) {
        Masp = masp;
        Tensp = tensp;
        Giatien = giatien;
        Soluong = soluong;
        Mota = mota;
        Thesim = thesim;
        Bonho = bonho;
        Ram = ram;
        Anhbia = anhbia;
        Madanhmuc = madanhmuc;
        Manguoidung = manguoidung;
    }

    public SanPham(String tensp, double giatien, int soluong, String mota, String thesim, String bonho, String ram, String anhbia, int madanhmuc, int manguoidung) {
        Tensp = tensp;
        Giatien = giatien;
        Soluong = soluong;
        Mota = mota;
        Thesim = thesim;
        Bonho = bonho;
        Ram = ram;
        Anhbia = anhbia;
        Madanhmuc = madanhmuc;
        Manguoidung = manguoidung;
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

    public String getThesim() {
        return Thesim;
    }

    public void setThesim(String thesim) {
        Thesim = thesim;
    }

    public String getBonho() {
        return Bonho;
    }

    public void setBonho(String bonho) {
        Bonho = bonho;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String ram) {
        Ram = ram;
    }

    public String getAnhbia() {
        return Anhbia;
    }

    public void setAnhbia(String anhbia) {
        Anhbia = anhbia;
    }

    public int getMadanhmuc() {
        return Madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        Madanhmuc = madanhmuc;
    }

    public int getManguoidung() {
        return Manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        Manguoidung = manguoidung;
    }
}
