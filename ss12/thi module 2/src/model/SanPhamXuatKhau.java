package model;

public class SanPhamXuatKhau extends SanPham{
    private double giaXuatKhau;
    private String quocGiaNhapSanPham;

    public SanPhamXuatKhau(){

    }

    public SanPhamXuatKhau(String id, String ma, String ten, double gia, int soLuong, String nsx, double giaXuatKhau, String quocGiaNhapSanPham){
        super(id, ma, ten, gia, soLuong, nsx);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;

    }

    public double getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(double giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSanPham() {
        return quocGiaNhapSanPham;
    }

    public void setQuocGiaNhapSanPham(String quocGiaNhapSanPham) {
        this.quocGiaNhapSanPham = quocGiaNhapSanPham;
    }

    public String toString(){
        return super.toString()+" gia xuat khau: "+getGiaXuatKhau()+" quoc gia nhap sap pham: "+getQuocGiaNhapSanPham();
    }
}
