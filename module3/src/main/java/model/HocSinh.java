package model;

public class HocSinh {
    protected int MaHS;
    protected String HoTen;
    protected String Lop;

    public HocSinh() {
    }

    public HocSinh(int maHS, String hoTen, String lop) {
        MaHS = maHS;
        HoTen = hoTen;
        Lop = lop;
    }

    public int getMaHS() {
        return MaHS;
    }

    public void setMaHS(int maHS) {
        MaHS = maHS;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }
}
