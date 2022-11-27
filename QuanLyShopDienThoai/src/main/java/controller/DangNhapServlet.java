package controller;

import dao.NguoiDungDAO;
import model.NguoiDung;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DangNhapServlet", urlPatterns = "/DangNhap")
public class DangNhapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("dangnhap.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String matKhau = request.getParameter("matkhau");
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        NguoiDung nguoiDung = nguoiDungDAO.dangNhap(email, matKhau);
        if(nguoiDung == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("dangnhap.jsp");
            dispatcher.forward(request, response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("nguoiDung", nguoiDung);
            // thời gian giũ session tài khoản
            session.setMaxInactiveInterval(120);
            response.sendRedirect("/TrangChu");
        }

    }
}
