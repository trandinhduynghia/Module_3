package controller;

import dao.HangSanXuatDAO;
import dao.SanPhamDAO;
import model.HangSanXuat;
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
        String Masp = request.getParameter("Masp");
        SanPhamDAO dao = new SanPhamDAO();
        List<SanPham> list = dao.danhSachSanPhamTheoMasp(Masp);
        request.setAttribute("list",list);

        HangSanXuatDAO dao1 = new HangSanXuatDAO();
        List<HangSanXuat> list1 = dao1.danhHangSanXuat();
        request.setAttribute("list1",list1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("chitietsanpham.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
