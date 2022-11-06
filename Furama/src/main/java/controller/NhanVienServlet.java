package controller;

import dao.NhanVienDAO;
import model.NhanVien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", urlPatterns = "/NhanVien")
public class NhanVienServlet extends HttpServlet {
    private static final long seialVersionUID = 1L;
    private NhanVienDAO nhanVienDAO;

    public void init(){
        nhanVienDAO = new NhanVienDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteNhanVien(request, response);
                    break;
                default:
                    listNhanVien(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }

    }

    private void listNhanVien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String q =  "";
        if (request.getParameter("q") != null) {
            q = request.getParameter("q");
        }
        List<NhanVien> listNhanVien = nhanVienDAO.selectAllNhanVien(q);
        request.setAttribute("listNhanVien",listNhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nhanvien/listnhanvien.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int MaNV = Integer.parseInt(request.getParameter("MaNV"));
        nhanVienDAO.deleteNhanVien(MaNV);
        String q =  "";
        List<NhanVien> nhanViens = nhanVienDAO.selectAllNhanVien(q);
        request.setAttribute("nhanViens",nhanViens);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nhanvien/listnhanvien.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("nhanvien/themnhanvien.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException{
        int MaNV = Integer.parseInt(request.getParameter("MaNV"));
        NhanVien existingNhanVien = nhanVienDAO.selectNhanVien(MaNV);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nhanvien/suanhanvien.jsp");
        request.setAttribute("existingNhanVien",existingNhanVien);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertNhanVien(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int MaNV = Integer.parseInt(request.getParameter("MaNV"));
        String HoTen = request.getParameter("HoTen");
        String NgaySinh = request.getParameter("NgaySinh");
        String SoCMND = request.getParameter("SoCMND");
        Double Luong = Double.parseDouble(request.getParameter("Luong"));
        String SoDT = request.getParameter("SoDT");
        String Email = request.getParameter("Email");
        String DiaChi = request.getParameter("DiaChi");
        Integer MaViTri = Integer.parseInt(request.getParameter("MaViTri"));
        Integer MaTrinhDo = Integer.parseInt(request.getParameter("MaTrinhDo"));
        Integer MaBoPhan = Integer.parseInt(request.getParameter("MaBoPhan"));

        NhanVien nhanVien = new NhanVien(MaNV, HoTen, NgaySinh, SoCMND, Luong, SoDT, Email, DiaChi, MaViTri, MaTrinhDo, MaBoPhan);
        nhanVienDAO.updateUser(nhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nhanvien/suanhanvien.jsp");
        dispatcher.forward(request, response);
    }

    private void insertNhanVien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String HoTen = request.getParameter("HoTen");
        String NgaySinh = request.getParameter("NgaySinh");
        String SoCMND = request.getParameter("SoCMND");
        Double Luong = Double.parseDouble(request.getParameter("Luong"));
        String SoDT = request.getParameter("SoDT");
        String Email = request.getParameter("Email");
        String DiaChi = request.getParameter("DiaChi");
        Integer MaViTri = Integer.parseInt(request.getParameter("MaViTri"));
        Integer MaTrinhDo = Integer.parseInt(request.getParameter("MaTrinhDo"));
        Integer MaBoPhan = Integer.parseInt(request.getParameter("MaBoPhan"));
        NhanVien newNhanVien = new NhanVien(HoTen, NgaySinh, SoCMND, Luong, SoDT, Email, DiaChi, MaViTri, MaTrinhDo, MaBoPhan);
        nhanVienDAO.insertNhanVien(newNhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nhanvien/themnhanvien.jsp");
        dispatcher.forward(request, response);
    }
}
