package controller;

import dao.DonHangDAO;
import model.GioHang;
import model.NguoiDung;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DonHangServlet", urlPatterns = "/DonHang")
public class DonHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        GioHang gioHang = null;
        Object o = session.getAttribute("gioHang");
        if (o != null) {
            gioHang = (GioHang) o;
        }else {
            gioHang = new GioHang();
        }
        NguoiDung nguoiDung = null;
        Object a = session.getAttribute("nguoiDung");
        if(a != null){
            nguoiDung = (NguoiDung) a;
            DonHangDAO donHangDAO = new DonHangDAO();
            donHangDAO.themDonHang(nguoiDung, gioHang);
            session.removeAttribute("gioHang");

            RequestDispatcher dispatcher = request.getRequestDispatcher("thanhtoan.jsp");
            dispatcher.forward(request, response);
        }else {
            response.sendRedirect("/DangNhap");
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        GioHang gioHang = null;
        Object o = session.getAttribute("gioHang");
        if (o != null) {
            gioHang = (GioHang) o;
        }else {
            gioHang = new GioHang();
        }
        NguoiDung nguoiDung = null;
        Object a = session.getAttribute("nguoiDung");
        if(a != null){
            nguoiDung = (NguoiDung) a;
            DonHangDAO donHangDAO = new DonHangDAO();
            donHangDAO.themDonHang(nguoiDung, gioHang);
            session.removeAttribute("gioHang");
            response.sendRedirect("/TrangChu");
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("dangnhap.jsp");
            dispatcher.forward(request, response);
        }

    }
}
