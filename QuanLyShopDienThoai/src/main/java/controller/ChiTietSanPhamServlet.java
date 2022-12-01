package controller;

import dao.SanPhamDAO;
import model.SanPham;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChiTietSanPhamServlet", urlPatterns = "/ChiTietSanPham")
public class ChiTietSanPhamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Masp = request.getParameter("masp");
        SanPhamDAO dao = new SanPhamDAO();
        SanPham sanPham = dao.sanPhamTheoMasp(Masp);
        request.setAttribute("sanPham",sanPham);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sanpham/chitietsanpham.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
