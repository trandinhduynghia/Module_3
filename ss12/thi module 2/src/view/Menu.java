package view;

import controller.QuanLySanPham;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
    Scanner scanner = new Scanner(System.in);
    private void menu() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM----");
        System.out.println("1. Thêm mới.");
        System.out.println("2. Xóa.");
        System.out.println("3. Xem danh sách.");
        System.out.println("4. Tìm kiếm.");
        System.out.println("5. Thoát.");
    }

    public void run() {
        int choice = -1;
        QuanLySanPham quanLySanPham = new QuanLySanPham();
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice > 5 || choice <0) {
                System.err.println("Menu chỉ có từ 1 - 5!");
            }
            switch (choice) {
                case 1: {
                    System.out.println("Nhập N để thêm sản phẩm nhập khẩu - Nhập X để thêm sản phẩm xuất khẩu ");
                    String a = scanner.nextLine();
                    switch (a){
                        case "N":
                            quanLySanPham.themSanPhamNhapKhau();
                            break;
                        case "X": {
                            quanLySanPham.themSanPhamXuatKhau();
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhập N để xóa sản phẩm nhập khẩu - Nhập X để xóa sản phẩm xuất khẩu");
                    String a = scanner.nextLine();
                    switch (a){
                        case "N":
                            quanLySanPham.xoaSanPhamNhapKhau();
                            break;
                        case "X":
                            quanLySanPham.xoaSanPhamXuatKhau();

                            break;
                    }
                    break;
                }
                case 3: {
                    System.out.println("Nhập N để xem sản phẩm nhập khẩu - Nhập X để xem sản phẩm xuất khẩu");
                    String a = scanner.nextLine();
                    switch (a){
                        case "N":
                            //quanLySanPham.hienThiSanPhamNhapKhau();
                            quanLySanPham.readFiles();
                            break;
                        case "X":
                            //quanLySanPham.hienThiSanPhamXuatKhau();
                            quanLySanPham.readFiles1();
                            break;
                    }
                    break;
                }
                case 4: {
                    System.out.println("Nhập N để tìm sản phẩm nhập khẩu - Nhập X để tìm sản phẩm xuất khẩu");
                    String a = scanner.nextLine();
                    switch (a){
                        case "N":
                            quanLySanPham.timKiemSanPhamNhapKhauTheoMa();
                            break;
                        case "X":
                            quanLySanPham.timKiemSanPhamXuatKhauTheoMa();
                            break;
                    }
                    break;
                }
            }
        } while (choice != 5);
    }
}
