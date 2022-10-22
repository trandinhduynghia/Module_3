package model;

public class SanPhamNhapKhau extends SanPham{
    private double giaNhapKhau;
    private String tinhThanhNhap;
    private double thueNhapKhau;

    public SanPhamNhapKhau(){

    }

    public SanPhamNhapKhau(String id, String ma, String ten, double gia, int soLuong, String nsx, double giaNhapKhau, String tinhThanhNhap,
                           double thueNhapKhau){
        super(id, ma, ten, gia, soLuong, nsx);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;

    }

    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public double getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(double thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    public String toString(){
        return super.toString()+" gia nhap khau: "+getGiaNhapKhau()+" tinh thanh nhap: "+getTinhThanhNhap()+
                " thue nhap khau: "+getThueNhapKhau();
    }
}
