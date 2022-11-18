package controller;

import dao.DanhMucDAO;
import dao.SanPhamDAO;
import model.DanhMuc;
import model.SanPham;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HangSanXuatServlet", urlPatterns = "/DanhMuc")
public class DanhMucServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    }
}
