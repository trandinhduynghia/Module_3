package model;

public class HangSanXuat {
    private int Mahang;
    private String Tenhang;

    public HangSanXuat() {
    }

    public HangSanXuat(int mahang, String tenhang) {
        this.Mahang = mahang;
        this.Tenhang = tenhang;
    }

    public int getMahang() {
        return Mahang;
    }

    public void setMahang(int mahang) {
        Mahang = mahang;
    }

    public String getTenhang() {
        return Tenhang;
    }

    public void setTenhang(String tenhang) {
        Tenhang = tenhang;
    }
}
