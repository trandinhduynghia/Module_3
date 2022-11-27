package controller;

import dao.NguoiDungDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DangKyServlet", urlPatterns = "/DangKy")
public class DangKyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dangky.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Hoten = request.getParameter("hoten");
        String Email = request.getParameter("email");
        String Dienthoai = request.getParameter("dienthoai");
        String Matkhau = request.getParameter("matkhau");
        String Matkhaulai = request.getParameter("matkhaulai");
        String Diachi = request.getParameter("diachi");
        int IDquyen = Integer.parseInt(request.getParameter("idquyen"));
        if (!Matkhau.equals(Matkhaulai)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("dangky.jsp");
            dispatcher.forward(request, response);
        } else {
            NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
            nguoiDungDAO.dangKy(Hoten, Email, Dienthoai, Matkhau, IDquyen, Diachi);
            response.sendRedirect("/TrangChu");
        }
    }
}