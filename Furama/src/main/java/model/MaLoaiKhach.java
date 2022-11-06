package model;

public class MaLoaiKhach {
    protected int MaLoaiKhach;
    protected String TenLoaiKhach;

    public MaLoaiKhach() {
    }

    public MaLoaiKhach(int maLoaiKhach, String tenLoaiKhach) {
        MaLoaiKhach = maLoaiKhach;
        TenLoaiKhach = tenLoaiKhach;
    }

    public int getMaLoaiKhach() {
        return MaLoaiKhach;
    }

    public void setMaLoaiKhach(int maLoaiKhach) {
        MaLoaiKhach = maLoaiKhach;
    }

    public String getTenLoaiKhach() {
        return TenLoaiKhach;
    }

    public void setTenLoaiKhach(String tenLoaiKhach) {
        TenLoaiKhach = tenLoaiKhach;
    }
}
