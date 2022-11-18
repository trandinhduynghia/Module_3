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
@WebServlet(name = "TrangChuServlet", urlPatterns = "/TrangChu")
public class TrangChuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String q =  "";
        if (request.getParameter("q") != null) {
            q = request.getParameter("q");
        }

        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        List<SanPham> sanPhams = sanPhamDAO.danhSachSanPham(q);
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
