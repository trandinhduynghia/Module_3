package controller;

import dao.NguoiDungDAO;
import model.NguoiDung;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ThongTinCaNhanServlet", urlPatterns = "/ThongTinCaNhan")
public class ThongTinCaNhanServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maNguoiDung = Integer.parseInt(request.getParameter("manguoidung"));
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        NguoiDung existingNguoiDung = nguoiDungDAO.nguoiDungTheoMa(maNguoiDung);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nguoidung/thongtincanhan.jsp");
        request.setAttribute("existingNguoiDung", existingNguoiDung);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Manguoidung = Integer.parseInt(request.getParameter("manguoidung"));
        String Hoten = request.getParameter("hoten");
        String Email = request.getParameter("email");
        String Dienthoai = request.getParameter("dienthoai");
        String Matkhau = request.getParameter("matkhau");
        String Matkhaulai = request.getParameter("matkhaulai");
        int IDquyen = Integer.parseInt(request.getParameter("idquyen"));
        String Diachi = request.getParameter("diachi");

        NguoiDung nguoiDung = new NguoiDung(Manguoidung, Hoten, Email, Dienthoai, Matkhau, IDquyen, Diachi);
        if (!Matkhau.equals(Matkhaulai)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("nguoidung/thongtincanhan.jsp");
            dispatcher.forward(request, response);
        } else {
            NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
            try {
                nguoiDungDAO.suaThongTinCaNhan(nguoiDung);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/TrangChu");
        }
    }

}
