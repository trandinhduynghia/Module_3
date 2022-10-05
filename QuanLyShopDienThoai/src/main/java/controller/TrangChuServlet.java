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

@WebServlet(name = "TrangChuServlet", urlPatterns = "/TrangChu")
public class TrangChuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //b1: lấy dữ liệu từ form dao
        SanPhamDAO dao = new SanPhamDAO();
        List<SanPham> list = dao.danhSachSanPham();
        //b2: set data to jsp
        request.setAttribute("list",list);

        HangSanXuatDAO dao1 = new HangSanXuatDAO();
        List<HangSanXuat> list1 = dao1.danhHangSanXuat();
        request.setAttribute("list1",list1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("trangchu2.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
