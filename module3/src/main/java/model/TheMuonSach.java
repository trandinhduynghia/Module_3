package model;

public class TheMuonSach {
    protected int MaMuonSach;
    protected int MaSach;
    protected int MaHocSinh;
    protected String TrangThai;
    protected String NgayMuon;
    protected String NgayTra;

    public TheMuonSach() {
    }

    public TheMuonSach(int maSach, int maHocSinh, String trangThai, String ngayMuon, String ngayTra) {
        MaSach = maSach;
        MaHocSinh = maHocSinh;
        TrangThai = trangThai;
        NgayMuon = ngayMuon;
        NgayTra = ngayTra;
    }

    public TheMuonSach(int maMuonSach, int maSach, int maHocSinh, String trangThai, String ngayMuon, String ngayTra) {
        MaMuonSach = maMuonSach;
        MaSach = maSach;
        MaHocSinh = maHocSinh;
        TrangThai = trangThai;
        NgayMuon = ngayMuon;
        NgayTra = ngayTra;
    }

    public int getMaMuonSach() {
        return MaMuonSach;
    }

    public void setMaMuonSach(int maMuonSach) {
        MaMuonSach = maMuonSach;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int maSach) {
        MaSach = maSach;
    }

    public int getMaHocSinh() {
        return MaHocSinh;
    }

    public void setMaHocSinh(int maHocSinh) {
        MaHocSinh = maHocSinh;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        NgayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(String ngayTra) {
        NgayTra = ngayTra;
    }
}
