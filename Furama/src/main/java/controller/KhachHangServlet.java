package controller;

import dao.KhachHangDAO;
import dao.NhanVienDAO;
import model.KhachHang;
import model.MaLoaiKhach;
import model.NhanVien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "KhachHangServlet", urlPatterns = "/KhachHang")
public class KhachHangServlet extends HttpServlet {
    private static final long seialVersionUID = 1L;
    private KhachHangDAO khachHangDAO;
    public void init(){
        khachHangDAO = new KhachHangDAO();
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
                    deleteKH(request, response);
                    break;
                default:
                    listKH(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }

    }

    private void listKH(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
         String q =  "";
        if (request.getParameter("q") != null) {
            q = request.getParameter("q");
        }
        List<KhachHang> listKH = khachHangDAO.hienThiKhachHang(q);
        request.setAttribute("listKH",listKH);

        List<MaLoaiKhach> maLoaiKhachs = khachHangDAO.hienThiMaLoaiKhach();
        request.setAttribute("maLoaiKhachs", maLoaiKhachs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteKH(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int MaKH = Integer.parseInt(request.getParameter("MaKH"));
        khachHangDAO.xoaKhachHang(MaKH);
        String q =  "";
        List<KhachHang> listKH = khachHangDAO.hienThiKhachHang(q);
        request.setAttribute("listKH",listKH);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<MaLoaiKhach> maLoaiKhachs = khachHangDAO.hienThiMaLoaiKhach();
        request.setAttribute("maLoaiKhachs", maLoaiKhachs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/themkhachhang.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException{
        int MaKH = Integer.parseInt(request.getParameter("MaKH"));
        KhachHang khachHang = khachHangDAO.timKhachHang(MaKH);
        request.setAttribute("khachHang", khachHang);

        List<MaLoaiKhach> maLoaiKhachs = khachHangDAO.hienThiMaLoaiKhach();
        request.setAttribute("maLoaiKhachs", maLoaiKhachs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/suakhachhang.jsp");
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
                    insertKH(request, response);
                    break;
                case "edit":
                    updateKH(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }

    }

    private void updateKH(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int MaKH = Integer.parseInt(request.getParameter("MaKH"));
        int MaLoaiKhach = Integer.parseInt(request.getParameter("MaLoaiKhach"));
        String HoTen = request.getParameter("HoTen");
        String NgaySinh = request.getParameter("NgaySinh");
        String GioiTinh = request.getParameter("GioiTinh");
        String SoCMND = request.getParameter("SoCMND");
        String SoDT = request.getParameter("SoDT");
        String Email = request.getParameter("Email");
        String DiaChi = request.getParameter("DiaChi");
        KhachHang khachHang = new KhachHang(MaKH, MaLoaiKhach, HoTen, NgaySinh, GioiTinh, SoCMND, SoDT, Email, DiaChi);
        khachHangDAO.capNhatKhachHang(khachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/suakhachhang.jsp");
        dispatcher.forward(request, response);
    }

    private void insertKH(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        //int MaKH = Integer.parseInt(request.getParameter("MaKH"));
        int MaLoaiKhach = Integer.parseInt(request.getParameter("MaLoaiKhach"));
        String HoTen = request.getParameter("HoTen");
        String NgaySinh = request.getParameter("NgaySinh");
        String GioiTinh = request.getParameter("GioiTinh");
        String SoCMND = request.getParameter("SoCMND");
        String SoDT = request.getParameter("SoDT");
        String Email = request.getParameter("Email");
        String DiaChi = request.getParameter("DiaChi");
        KhachHang khachHang = new KhachHang(MaLoaiKhach, HoTen, NgaySinh, GioiTinh, SoCMND, SoDT, Email, DiaChi);
        khachHangDAO.themKhachHang(khachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
        dispatcher.forward(request, response);
    }
}
