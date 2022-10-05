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
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void danhSachNguoiDung(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int trang = 1;
        int soLuongTrongTrang = 10;
        String hoTen = "";

        if(request.getParameter("hoTen")!=null){
            hoTen = request.getParameter("hoTen");
        }

        if(request.getParameter("trang") != null)
            trang = Integer.parseInt(request.getParameter("trang"));
        NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();
        List<NguoiDung> listNguoiDung = nguoiDungDAO.danhSachNguoiDung((trang-1)*soLuongTrongTrang, soLuongTrongTrang, hoTen);
        int soLuong = nguoiDungDAO.getSoLuong();

        int soLuongTrang = (int) Math.ceil(soLuong * 1.0 / soLuongTrongTrang);

        request.setAttribute("listNguoiDung", listNguoiDung);
        request.setAttribute("soLuongTrang", soLuongTrang);
        request.setAttribute("trang", trang);

        request.setAttribute("hoTen", hoTen);

        RequestDispatcher dispatcher = request.getRequestDispatcher("danhsachnguoidung.jsp");
        dispatcher.forward(request, response);
    }

    private void xoaNguoidung(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int maNguoiDung = Integer.parseInt(request.getParameter("manguoidung"));
        NguoiDungDAO  nguoiDungDAO = new NguoiDungDAO();
        nguoiDungDAO.xoaNguoiDung(maNguoiDung);
        RequestDispatcher dispatcher = request.getRequestDispatcher("danhsachnguoidung.jsp");
        dispatcher.forward(request, response);
    }

    private void formSuaNguoiDung(HttpServletRequest request, HttpServletResponse response)  throws SQLException, ServletException, IOException{
        int maNguoiDung = Integer.parseInt(request.getParameter("manguoidung"));
        NguoiDungDAO  nguoiDungDAO = new NguoiDungDAO();
        NguoiDung existingNguoiDung = nguoiDungDAO.nguoiDungTheoMa(maNguoiDung);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nguoidung/suanguoidung.jsp");
        request.setAttribute("existingNguoiDung",existingNguoiDung);
        dispatcher.forward(request,response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "crate":
                    response.sendRedirect("/DangKy");
                    break;
                case "edit":
                    suaNguoiDung(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void suaNguoiDung(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException {
        int Manguoidung = Integer.parseInt(request.getParameter("manguoidung"));
        String Hoten = request.getParameter("hoten");
        String Email = request.getParameter("email");
        String Dienthoai = request.getParameter("dienthoai");
        String Matkhau = request.getParameter("matkhau");
        int IDquyen = Integer.parseInt(request.getParameter("idquyen"));
        NguoiDung nguoiDung = new NguoiDung(Manguoidung, Hoten, Email, Dienthoai, Matkhau, IDquyen);
        NguoiDungDAO  nguoiDungDAO = new NguoiDungDAO();
        nguoiDungDAO.suaNguoiDung(nguoiDung);
        RequestDispatcher dispatcher = request.getRequestDispatcher("danhsachnguoidung.jsp");
        dispatcher.forward(request, response);
    }

}
