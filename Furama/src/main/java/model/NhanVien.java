package model;

public class NhanVien {
    protected int MaNV;
    protected String HoTen;
    protected String NgaySinh;
    protected String SoCMND;
    protected double Luong;
    protected String SoDT;
    protected String Email;
    protected String DiaChi;
    protected int MaViTri;
    protected int MaTrinhDo;
    protected int MaBoPhan;

    public NhanVien(){

    }

    public NhanVien(int MaNV, String HoTen, String NgaySinh, String SoCMND, double Luong, String SoDT, String Email,
                     String DiaChi, int MaViTri, int MaTrinhDo, int MaBoPhan ){
        super();
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.SoCMND = SoCMND;
        this.Luong = Luong;
        this.SoDT = SoDT;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.MaViTri = MaViTri;
        this.MaTrinhDo = MaTrinhDo;
        this.MaBoPhan = MaBoPhan;
    }

    public NhanVien(String HoTen, String NgaySinh, String SoCMND, double Luong, String SoDT, String Email,
                    String DiaChi, int MaViTri, int MaTrinhDo, int MaBoPhan ){
        super();
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.SoCMND = SoCMND;
        this.Luong = Luong;
        this.SoDT = SoDT;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.MaViTri = MaViTri;
        this.MaTrinhDo = MaTrinhDo;
        this.MaBoPhan = MaBoPhan;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int maNV) {
        MaNV = maNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSoCMND() {
        return SoCMND;
    }

    public void setSoCMND(String soCMND) {
        SoCMND = soCMND;
    }

    public double getLuong() {
        return Luong;
    }

    public void setLuong(double luong) {
        Luong = luong;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getMaViTri() {
        return MaViTri;
    }

    public void setMaViTri(int maViTri) {
        MaViTri = maViTri;
    }

    public int getMaTrinhDo() {
        return MaTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        MaTrinhDo = maTrinhDo;
    }

    public int getMaBoPhan() {
        return MaBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        MaBoPhan = maBoPhan;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "MaNV=" + MaNV +
                ", HoTen='" + HoTen + '\'' +
                ", NgaySinh='" + NgaySinh + '\'' +
                ", SoCMND='" + SoCMND + '\'' +
                ", Luong=" + Luong +
                ", SoDT='" + SoDT + '\'' +
                ", Email='" + Email + '\'' +
                ", DiaChi='" + DiaChi + '\'' +
                ", MaViTri=" + MaViTri +
                ", MaTrinhDo=" + MaTrinhDo +
                ", MaBoPhan=" + MaBoPhan +
                '}';
    }
}
