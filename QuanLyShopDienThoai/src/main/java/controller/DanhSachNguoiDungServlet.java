package controller;

import dao.NguoiDungDAO;
import model.NguoiDung;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "DanhSachNguoiDungServlet", urlPatterns = "/DanhSachNguoiDung")
public class DanhSachNguoiDungServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    response.sendRedirect("/DangKy");
                    break;
                case "edit":
                    formSuaNguoiDung(request, response);
                    break;
                case "delete":
                    xoaNguoidung(request, response);
                    break;
                default:
                    danhSachNguoiDung(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void danhSachNguoiDung(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String hoTen = "";
        if (request.getParameter("hoTen") != null) {
            hoTen = request.getParameter("hoTen");
        }

        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        List<NguoiDung> listNguoiDung = nguoiDungDAO.danhSachNguoiDung(hoTen);
        request.setAttribute("listNguoiDung", listNguoiDung);
        request.setAttribute("hoTen", hoTen);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nguoidung/danhsachnguoidung.jsp");
        dispatcher.forward(request, response);
    }

    private void xoaNguoidung(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int maNguoiDung = Integer.parseInt(request.getParameter("manguoidung"));
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        nguoiDungDAO.xoaNguoiDung(maNguoiDung);
        response.sendRedirect("/DanhSachNguoiDung");
    }

    private void formSuaNguoiDung(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int maNguoiDung = Integer.parseInt(request.getParameter("manguoidung"));
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        NguoiDung existingNguoiDung = nguoiDungDAO.nguoiDungTheoMa(maNguoiDung);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nguoidung/suanguoidung1.jsp");
        request.setAttribute("existingNguoiDung", existingNguoiDung);
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    response.sendRedirect("/DangKy");
                    break;
                case "edit":
                    suaNguoiDung(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void suaNguoiDung(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("nguoidung/canhan.jsp");
//            request.setAttribute("existingNguoiDung", nguoiDung);
            dispatcher.forward(request, response);
        } else {
            NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
            try {
                nguoiDungDAO.suaNguoiDung(nguoiDung);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/DanhSachNguoiDung");
        }
    }
}