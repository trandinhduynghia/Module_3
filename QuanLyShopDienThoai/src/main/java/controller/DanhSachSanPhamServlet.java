package controller;

import dao.NguoiDungDAO;
import dao.SanPhamDAO;
import model.NguoiDung;
import model.SanPham;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DanhSachSanPhamServlet", urlPatterns = "/DanhSachSanPham")
public class DanhSachSanPhamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    formThemSanPham(request, response);
                    break;
                case "edit":
                    formSuaSanPham(request, response);
                    break;
                case "delete":
                    xoaSanPham(request, response);
                    break;
                default:
                    danhSachSanPham(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void danhSachSanPham(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String Manguoidung = request.getParameter("manguoidung");
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> listSanPham = sanPhamDAO.danhSachSanPhamTheoMaNguoiDung(Manguoidung);
        request.setAttribute("listSanPham", listSanPham);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sanpham/index.jsp");
        dispatcher.forward(request, response);
    }

    private void xoaSanPham(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int Masp = Integer.parseInt(request.getParameter("masp"));
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamDAO.xoaSanPham(Masp);
        response.sendRedirect("/TrangChu");
    }

    private void formSuaSanPham(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String Masp = request.getParameter("masp");
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        SanPham sanPham = sanPhamDAO.sanPhamTheoMasp(Masp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("suasanpham/index.jsp");
        request.setAttribute("sanPham", sanPham);
        dispatcher.forward(request, response);
    }
    private void formThemSanPham(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("themsanpham/index.jsp");
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
                case "create":
                    themSanPham(request, response);
                    break;
                case "edit":
                    suaSanPham(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void suaSanPham(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int Masp = Integer.parseInt(request.getParameter("masp"));
        String Tensp = request.getParameter("tensp");
        Double Giatien = Double.valueOf(request.getParameter("giatien"));
        int Soluong = Integer.parseInt(request.getParameter("soluong"));
        String Mota = request.getParameter("mota");
        String Thesim = request.getParameter("thesim");
        String Bonho = request.getParameter("bonho");
        String Ram = request.getParameter("ram");
        String Anhbia = request.getParameter("anhbia");
        int Madanhmuc = Integer.parseInt(request.getParameter("madanhmuc"));
        int Manguoidung = Integer.parseInt(request.getParameter("manguoidung"));
        SanPham sanPham = new SanPham(Masp, Tensp, Giatien, Soluong, Mota, Thesim, Bonho, Ram, Anhbia, Madanhmuc, Manguoidung);
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamDAO.suaSanPham(sanPham);
        response.sendRedirect("/DanhSachSanPham");
    }

    private void themSanPham(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int Masp = Integer.parseInt(request.getParameter("masp"));
        String Tensp = request.getParameter("tensp");
        Double Giatien = Double.valueOf(request.getParameter("giatien"));
        int Soluong = Integer.parseInt(request.getParameter("soluong"));
        String Mota = request.getParameter("mota");
        String Thesim = request.getParameter("thesim");
        String Bonho = request.getParameter("bonho");
        String Ram = request.getParameter("ram");
        String Anhbia = request.getParameter("anhbia");
        int Madanhmuc = Integer.parseInt(request.getParameter("madanhmuc"));
        int Manguoidung = Integer.parseInt(request.getParameter("manguoidung"));
        SanPham sanPham = new SanPham(Tensp, Giatien, Soluong, Mota, Thesim, Bonho, Ram, Anhbia, Madanhmuc, Manguoidung);
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        sanPhamDAO.themSanPham(sanPham);
        response.sendRedirect("/TrangChu");
    }
}
