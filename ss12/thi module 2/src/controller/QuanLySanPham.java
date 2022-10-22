package controller;

import Validate.Validate;
import model.SanPhamNhapKhau;
import model.SanPhamXuatKhau;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLySanPham {
    Scanner scanner = new Scanner(System.in);
    public List<SanPhamNhapKhau> sanPhamNhapKhaus = new ArrayList<>();
    public List<SanPhamXuatKhau> sanPhamXuatKhaus = new ArrayList<>();



    public void themSanPhamNhapKhau() {
        System.out.println("id: ");
        String id = scanner.nextLine();
        System.out.println("ma: ");
        String ma = scanner.nextLine();
        System.out.println("ten: ");
        String ten = scanner.nextLine();
        System.out.println("gia: ");
        double gia = Validate.validateSoTien();
        System.out.println("so luong: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("nsx: ");
        String nsx = scanner.nextLine();
        System.out.println("gia nhap khau: ");
        double giaNhapKhau = Validate.validateSoTien();
        System.out.println("tinh thanh nhap: ");
        String tinhThanhNhap = scanner.nextLine();
        System.out.println("thue nhap khau: ");
        double thueNhapKhau = Double.parseDouble(scanner.nextLine());
        SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(id, ma, ten, gia, soLuong, nsx, giaNhapKhau, tinhThanhNhap, thueNhapKhau);
        sanPhamNhapKhaus = readFiles();
        sanPhamNhapKhaus.add(sanPhamNhapKhau);
        System.out.println("Thêm thành công!");
        writeToFiles();
    }

    public int timSanPhamNhapKhau(String name) {
        int index = -1;
        for(int i = 0; i < sanPhamNhapKhaus.size(); i++){
            if(sanPhamNhapKhaus.get(i).getId().equals(name))
                index = i;
        }

        return index;
    }

    public void timKiemSanPhamNhapKhauTheoMa() {
        sanPhamNhapKhaus = readFiles();
        System.out.println("id: ");
        String id = scanner.nextLine();
        int index = timSanPhamNhapKhau(id);
        if (index == -1) {
            System.err.println("San pham khong ton tai");
        } else {
            sanPhamNhapKhaus.get(index).toString();
        }
    }
    public void xoaSanPhamNhapKhau() {
        sanPhamNhapKhaus = readFiles();
        System.out.println("id: ");
        String id = scanner.nextLine();
        int index = timSanPhamNhapKhau(id);
        if (index == -1) {
            System.err.println("San pham khong ton tai");
        } else {
            sanPhamNhapKhaus.remove(index);
            System.out.println("Xóa thành công!");
        }
        writeToFiles();
    }


    public void hienThiSanPhamNhapKhau() {
        sanPhamNhapKhaus = readFiles();
        for (SanPhamNhapKhau sanPhamNhapKhau : sanPhamNhapKhaus){
            System.out.println(sanPhamNhapKhau.toString());
        }
    }

    public List<SanPhamNhapKhau> readFiles()  {
        String DELIMITER = ",";
        String EMPTY = "";
        List<SanPhamNhapKhau> sanPhamNhapKhaus = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Module3\\ss12\\thi module 2\\src\\data\\sanphamnhapkhau.csv"))){
            String temp;
            while ((temp = reader.readLine()) != null){
                if(EMPTY.equals(temp.trim())){
                    continue;
                }
                String[] result = temp.split(DELIMITER);
                if(result.length != 9){
                    continue;
                }

                String id = result[0];
                String  ma = result[1];
                String ten = result[2];
                double gia = Double.parseDouble(result[3]);
                int soLuong = Integer.parseInt(result[4]);
                String nsx = result[5];
                double giaNhapKhau = Double.parseDouble(result[6]);
                String tinhThanhNhap = result[7];
                double thueNhapKhau = Double.parseDouble(result[8]);

                sanPhamNhapKhaus.add(new SanPhamNhapKhau(id, ma, ten, gia, soLuong, nsx, giaNhapKhau, tinhThanhNhap, thueNhapKhau));
            }
            for(SanPhamNhapKhau sanPhamNhapKhau : sanPhamNhapKhaus){
            System.out.println(sanPhamNhapKhau.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return sanPhamNhapKhaus;
    }

    public void writeToFiles() {
        String DELIMITER = ",";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Module3\\ss12\\thi module 2\\src\\data\\sanphamnhapkhau.csv", false))){
            for(SanPhamNhapKhau sanPhamNhapKhau: sanPhamNhapKhaus){
                writer.write(sanPhamNhapKhau.getId()+DELIMITER+sanPhamNhapKhau.getMa()+DELIMITER+sanPhamNhapKhau.getTen()+DELIMITER+sanPhamNhapKhau.getGia()+DELIMITER+sanPhamNhapKhau.getSoLuong()+DELIMITER
                        +sanPhamNhapKhau.getNsx()+DELIMITER+sanPhamNhapKhau.getGiaNhapKhau()+DELIMITER+sanPhamNhapKhau.getTinhThanhNhap()+DELIMITER
                        +sanPhamNhapKhau.getThueNhapKhau());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void themSanPhamXuatKhau() {
        System.out.println("id: ");
        String id = scanner.nextLine();
        System.out.println("ma: ");
        String ma = scanner.nextLine();
        System.out.println("ten: ");
        String ten = scanner.nextLine();
        System.out.println("gia: ");
        double gia = Double.parseDouble(scanner.nextLine());
        System.out.println("so luong: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("nsx: ");
        String nsx = scanner.nextLine();
        System.out.println("gia xuat khau: ");
        double giaXuatKhau = Double.parseDouble(scanner.nextLine());
        System.out.println("quoc gia nhap san pham: ");
        String quocGiaNhapSanPham = scanner.nextLine();
        SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(id, ma, ten, gia, soLuong, nsx, giaXuatKhau, quocGiaNhapSanPham );
        sanPhamXuatKhaus = readFiles1();
        sanPhamXuatKhaus.add(sanPhamXuatKhau);
        System.out.println("Thêm thành công!");
        writeToFiles1();
    }

    public int timSanPhamXuatKhau(String name) {
        int index = -1;
        for(int i = 0; i < sanPhamXuatKhaus.size(); i++){
            if(sanPhamXuatKhaus.get(i).getId().equals(name))
                index = i;
        }
        return index;
    }



    public void timKiemSanPhamXuatKhauTheoMa() {
        sanPhamXuatKhaus = readFiles1();
        System.out.println("id: ");
        String id = scanner.nextLine();
        int index = timSanPhamXuatKhau(id);
        if (index == -1) {
            System.err.println("San pham khong ton tai");
        } else {
            sanPhamXuatKhaus.get(index).toString();
        }
    }
    public void xoaSanPhamXuatKhau() {
        sanPhamXuatKhaus = readFiles1();
        System.out.println("id: ");
        String id = scanner.nextLine();
        int index = timSanPhamXuatKhau(id);
        if (index == -1) {
            System.err.println("San pham khong ton tai");
        } else {
            sanPhamNhapKhaus.remove(index);
            System.out.println("Xóa thành công!");
        }
        writeToFiles1();
    }


    public void hienThiSanPhamXuatKhau() {
        sanPhamXuatKhaus = readFiles1();
        for (SanPhamNhapKhau sanPhamNhapKhau : sanPhamNhapKhaus){
            System.out.println(sanPhamNhapKhau.toString());
        }
    }

    public List<SanPhamXuatKhau> readFiles1()  {
        String DELIMITER = ",";
        String EMPTY = "";
        List<SanPhamXuatKhau> sanPhamXuatKhaus = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Module3\\ss12\\thi module 2\\src\\data\\sanphamxuatkhau.csv"))){
            String temp;
            while ((temp = reader.readLine()) != null){
                if(EMPTY.equals(temp.trim())){
                    continue;
                }
                String[] result = temp.split(DELIMITER);
                if(result.length != 8){
                    continue;
                }

                String id = result[0];
                String  ma = result[1];
                String ten = result[2];
                double gia = Double.parseDouble(result[3]);
                int soLuong = Integer.parseInt(result[4]);
                String nsx = result[5];
                double giaXuatKhau = Double.parseDouble(result[6]);
                String quoGiaNhapSanPham = result[7];
                sanPhamXuatKhaus.add(new SanPhamXuatKhau(id, ma, ten, gia, soLuong, nsx, giaXuatKhau, quoGiaNhapSanPham));
            }
            for(SanPhamXuatKhau sanPhamXuatKhau : sanPhamXuatKhaus){
                System.out.println(sanPhamXuatKhau.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return sanPhamXuatKhaus;
    }

    public void writeToFiles1() {
        String DELIMITER = ",";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Module3\\ss12\\thi module 2\\src\\data\\sanphamxuatkhau.csv", false))){
            for(SanPhamXuatKhau sanPhamXuatKhau: sanPhamXuatKhaus){
                writer.write(sanPhamXuatKhau.getId()+DELIMITER+sanPhamXuatKhau.getMa()+DELIMITER+sanPhamXuatKhau.getTen()+DELIMITER+sanPhamXuatKhau.getGia()+DELIMITER+sanPhamXuatKhau.getSoLuong()+DELIMITER
                        +sanPhamXuatKhau.getNsx()+DELIMITER+sanPhamXuatKhau.getGiaXuatKhau()+DELIMITER+sanPhamXuatKhau.getQuocGiaNhapSanPham());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
