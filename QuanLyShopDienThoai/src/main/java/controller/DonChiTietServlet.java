package controller;

import dao.ChiTietDonHangDAO;
import dao.DonHangDAO;
import dao.SanPhamDAO;
import model.ChiTietDonHang;
import model.SanPham;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DonChiTietServlet", urlPatterns = "/DonChiTiet")
public class DonChiTietServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "chitiet":
                    chitietDonHang(request, response);
                    break;
                default:
                    response.sendRedirect("/TrangChu");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void chitietDonHang(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int Madon = Integer.parseInt(request.getParameter("madon"));
        ChiTietDonHangDAO chiTietDonHangDAO = new ChiTietDonHangDAO();
        List<ChiTietDonHang> chiTietDonHangs = chiTietDonHangDAO.chiTietDonHang(Madon);
        Double tongTien = chiTietDonHangDAO.tongTien(Madon);
        request.setAttribute("list", chiTietDonHangs);
        request.setAttribute("tongTien", tongTien);

        String q = "";
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> sanPhams = sanPhamDAO.danhSachSanPham(q);
        request.setAttribute("sanPhams", sanPhams);

        RequestDispatcher dispatcher = request.getRequestDispatcher("donhang/chitietdonhang.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    }


