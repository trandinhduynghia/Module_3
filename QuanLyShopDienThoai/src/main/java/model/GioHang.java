package model;

import java.util.ArrayList;
import java.util.List;

public class GioHang {
    private List<MatHang> matHangs;

    public GioHang(){
        matHangs=new ArrayList<>();
    }

    private GioHang(List<MatHang> matHangs){
        this.matHangs = matHangs;
    }

    public List<MatHang> getMatHangs() {
        return matHangs;
    }

    public void setMatHangs(List<MatHang> matHangs) {
        this.matHangs = matHangs;
    }

    private MatHang getMatHangBoiMasp(int Masp){
        for(MatHang i : matHangs){
            if(i.getSanpham().getMasp() == Masp){
                return i;
            }
        }
        return null;
    }

    public int getSoLuongBoiMasp(int Masp){
        return getMatHangBoiMasp(Masp).getSoluong();
    }

    // them vao gio hang
    public void themMatHang(MatHang matHang){
        // mat hang da co trong gio
        if(getMatHangBoiMasp(matHang.getSanpham().getMasp()) != null){
            MatHang matHang1 = getMatHangBoiMasp(matHang.getSanpham().getMasp());
            matHang1.setSoluong(matHang1.getSoluong()+matHang.getSoluong());
        }else {
            matHangs.add(matHang);
        }
    }

    public void xoaMatHang(int Masp){
        if(getMatHangBoiMasp(Masp) != null) {
            matHangs.remove(getMatHangBoiMasp(Masp));
        }
    }

    public double getThanhTien(){
        double thanhTien = 0;
        for(MatHang i : matHangs){
            thanhTien += i.getSoluong() * i.getDongia();
        }
        return thanhTien;
    }

}
