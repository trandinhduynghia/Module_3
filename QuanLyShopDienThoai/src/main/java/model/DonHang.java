package model;

public class DonHang {
    private int Madon;
    private String Ngaydat;
    private String Tinhtrang;
    private int Manguoidung;

    public DonHang() {
    }

    public DonHang(int madon, String ngaydat, String tinhtrang, int manguoidung) {
        this.Madon = madon;
        this.Ngaydat = ngaydat;
        this.Tinhtrang = tinhtrang;
        this.Manguoidung = manguoidung;
    }

    public int getMadon() {
        return Madon;
    }

    public void setMadon(int madon) {
        Madon = madon;
    }

    public String getNgaydat() {
        return Ngaydat;
    }

    public void setNgaydat(String ngaydat) {
        Ngaydat = ngaydat;
    }

    public String getTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        Tinhtrang = tinhtrang;
    }

    public int getManguoidung() {
        return Manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        Manguoidung = manguoidung;
    }
}
