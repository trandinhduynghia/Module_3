package model;

public class NguoiDung {
    private int Manguoidung;
    private String Hoten;
    private String Email;
    private String Dienthoai;
    private String Matkhau;
    private int IDquyen;

    public NguoiDung() {
    }

    public NguoiDung(int manguoidung, String hoten, String email, String dienthoai, String matkhau, int IDquyen) {
        Manguoidung = manguoidung;
        Hoten = hoten;
        Email = email;
        Dienthoai = dienthoai;
        Matkhau = matkhau;
        this.IDquyen = IDquyen;
    }

    public int getManguoidung() {
        return Manguoidung;
    }

    public void setManguoidung(int manguoidung) {
        Manguoidung = manguoidung;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDienthoai() {
        return Dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        Dienthoai = dienthoai;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String matkhau) {
        Matkhau = matkhau;
    }

    public int getIDquyen() {
        return IDquyen;
    }

    public void setIDquyen(int IDquyen) {
        this.IDquyen = IDquyen;
    }
}
