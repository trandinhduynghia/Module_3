package controller;

import dao.DonHangDAO;
import dao.NguoiDungDAO;
import model.ChiTietDonHang;
import model.DonHang;
import model.NguoiDung;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ChiTietDonHangServlet", urlPatterns = "/ChiTietDonHang")
public class ChiTietDonHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "donhangtheonguoidung":
                    donHangTheoNguoiDung(request, response);
                    break;
                case "donhangtheonguoiban":
                    donHangTheoNguoiBan(request, response);
                    break;
                default:
                    response.sendRedirect("/TrangChu");
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void donHangTheoNguoiDung(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int manguoidung = Integer.parseInt(request.getParameter("manguoidung"));
        DonHangDAO donHangDAO = new DonHangDAO();
        List<DonHang> donHangs = donHangDAO.donHangTheoMaNguoiDung(manguoidung);
        request.setAttribute("donHangs", donHangs);

        String q = "";
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        List<NguoiDung> nguoiDungs = nguoiDungDAO.danhSachNguoiDung(q);
        request.setAttribute("nguoiDungs", nguoiDungs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("donhang/donhangtheonguoidung.jsp");
        dispatcher.forward(request, response);
    }

    private void donHangTheoNguoiBan(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int manguoiban = Integer.parseInt(request.getParameter("manguoiban"));
        DonHangDAO donHangDAO = new DonHangDAO();
        List<DonHang> donHangs = donHangDAO.donHangTheoMaNguoiBan(manguoiban);
        request.setAttribute("donHangs", donHangs);

        String q = "";
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        List<NguoiDung> nguoiDungs = nguoiDungDAO.danhSachNguoiDung(q);
        request.setAttribute("nguoiDungs", nguoiDungs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("donhang/donhangtheonguoidung.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
