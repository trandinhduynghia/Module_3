package model;

import dao.NhanVienDAO;

import java.util.List;

public class demo {
    public static void main(String[] args) {
        NhanVienDAO nhanVienDAO = new NhanVienDAO();
        List<NhanVien> nhanviens = nhanVienDAO.selectAllNhanVien();

        for (int i = 0; i < nhanviens.size(); i++){
            System.out.println(nhanviens.get(i).toString());
        }
    }
}
