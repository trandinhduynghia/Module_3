package controller;

import dao.DanhMucDAO;
import dao.NguoiDungDAO;
import dao.SanPhamDAO;
import model.DanhMuc;
import model.NguoiDung;
import model.SanPham;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HangSanXuatServlet", urlPatterns = "/DanhMuc")
public class DanhMucServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    response.sendRedirect("/DangKy");
                    break;
                case "edit":
                    formSuaDanhMuc(request, response);
                    break;
                case "delete":
                    xoaDanhMuc(request, response);
                    break;
                case "sanphamtheodanhmuc":
                    sanPhamTheoDanhMuc(request, response);
                default:
                    danhSachDanhMuc(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }



    }

    private void danhSachDanhMuc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        List<DanhMuc> listDanhmuc = danhMucDAO.listDanhMuc();
        request.setAttribute("listDanhmuc", listDanhmuc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("danhmuc/danhmuc.jsp");
        dispatcher.forward(request, response);
    }

    private void xoaDanhMuc(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int Madanhmuc = Integer.parseInt(request.getParameter("madanhmuc"));
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        danhMucDAO.xoaDanhMuc(Madanhmuc);
        response.sendRedirect("/DanhMuc");
    }

    private void formSuaDanhMuc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int MaDanhmuc = Integer.parseInt(request.getParameter("madanhmuc"));
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        DanhMuc danhMuc = danhMucDAO.timDanhMuc(MaDanhmuc);
        request.setAttribute("danhMuc", danhMuc);
        RequestDispatcher dispatcher = request.getRequestDispatcher("");
        dispatcher.forward(request, response);
    }

    private void sanPhamTheoDanhMuc(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String Madanhmuc = request.getParameter("Madanhmuc");

        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> sanPhams = sanPhamDAO.danhSachSanPhamTheoMaDanhMuc(Madanhmuc);
        request.setAttribute("sanPhams",sanPhams);

        DanhMucDAO danhMucDAO = new DanhMucDAO();
        List<DanhMuc> danhMucs = danhMucDAO.listDanhMuc();
        request.setAttribute("danhMucs", danhMucs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ogani-master/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "crate":
                    themDanhmuc(request, response);
                    break;
                case "edit":
                    suaDanhMuc(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void suaDanhMuc(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int Madanhmuc = Integer.parseInt(request.getParameter("madanhmuc"));
        String Tendanhmuc = request.getParameter("tendanhmuc");
        DanhMuc danhMuc = new DanhMuc(Madanhmuc, Tendanhmuc);
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        danhMucDAO.suaDanhMuc(danhMuc);
        response.sendRedirect("/DanhMuc");
    }

    private void themDanhmuc(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int Madanhmuc = Integer.parseInt(request.getParameter("madanhmuc"));
        String Tendanhmuc = request.getParameter("tendanhmuc");
        DanhMuc danhMuc = new DanhMuc(Madanhmuc, Tendanhmuc);
        DanhMucDAO danhMucDAO = new DanhMucDAO();
        danhMucDAO.themDanhmuc(danhMuc);
        response.sendRedirect("/DanhMuc");
    }
}
