package model;

public abstract class SanPham {
    private String id;
    private String ma;
    private String ten;
    private double gia;
    private int soLuong;
    private String nsx;

    public SanPham(){

    }

    public SanPham(String id, String ma, String ten, double gia, int soLuong, String nsx){
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nsx = nsx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String toString(){
        return "id: "+getId()+ " ma: "+getMa()+  " ten: "+getTen()+ " gia: "+getGia()+" soLuong: "+getSoLuong()+ " nsx: "
                +getNsx();
    }
}
