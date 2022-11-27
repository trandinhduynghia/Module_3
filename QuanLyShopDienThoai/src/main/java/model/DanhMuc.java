package model;

public class DanhMuc {
    private int Madanhmuc;
    private String Tendanhmuc;

    public DanhMuc() {
    }

    public DanhMuc(int madanhmuc, String tendanhmuc) {
        Madanhmuc = madanhmuc;
        Tendanhmuc = tendanhmuc;
    }

    public DanhMuc(String tendanhmuc) {
        Tendanhmuc = tendanhmuc;
    }

    public int getMadanhmuc() {
        return Madanhmuc;
    }

    public void setMadanhmuc(int madanhmuc) {
        Madanhmuc = madanhmuc;
    }

    public String getTendanhmuc() {
        return Tendanhmuc;
    }

    public void setTendanhmuc(String tendanhmuc) {
        Tendanhmuc = tendanhmuc;
    }
}
