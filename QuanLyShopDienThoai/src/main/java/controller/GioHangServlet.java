package controller;

import dao.NguoiDungDAO;
import dao.SanPhamDAO;
import model.GioHang;
import model.MatHang;
import model.SanPham;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GioHangServlet", urlPatterns = "/GioHang")
public class GioHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    themGioHang(request, response);
                    break;
                case "delete":
                    xoaGioHang(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("giohang/giohang.jsp");
                    dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void themGioHang(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int Soluong = 1;
        String Masp ;
        int Masp1;
        if(request.getParameter("masp") != null) {
            Masp = request.getParameter("masp");
            Masp1 = Integer.parseInt(request.getParameter("masp"));
            SanPhamDAO sanPhamDAO = new SanPhamDAO();
            SanPham sanPham = sanPhamDAO.sanPhamTheoMasp(Masp);
            if (sanPham != null) {
                if (request.getParameter("soluong") != null) {
                    Soluong = Integer.parseInt(request.getParameter("soluong"));
                }
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(500);
                if (session.getAttribute("gioHang") == null) {
                    GioHang gioHang = new GioHang();
                    List<MatHang> listMatHang = new ArrayList<>();
                    MatHang matHang = new MatHang();
                    matHang.setSanpham(sanPham);
                    matHang.setSoluong(Soluong);
                    matHang.setDongia(sanPham.getGiatien());
                    listMatHang.add(matHang);
                    gioHang.setMatHangs(listMatHang);
                    if(Soluong < 0){
                        gioHang.xoaMatHang(Masp1);
                    }
                    session.setAttribute("gioHang", gioHang);
                }else {
                    GioHang gioHang = (GioHang) session.getAttribute("gioHang");
                    List<MatHang> listMatHang = gioHang.getMatHangs();
                    boolean check = false;
                    for (MatHang matHang : listMatHang){
                        if(matHang.getSanpham().getMasp() == sanPham.getMasp()){
                            matHang.setSoluong(matHang.getSoluong()+Soluong);
                            check = true;
                        }
                    }
                    if(check == false){
                        MatHang matHang = new MatHang();
                        matHang.setSanpham(sanPham);
                        matHang.setSoluong(Soluong);
                        matHang.setDongia(sanPham.getGiatien());
                        listMatHang.add(matHang);
                    }
                    if(Soluong < 0){
                        gioHang.xoaMatHang(Masp1);
                    }
                    session.setAttribute("gioHang", gioHang);
                }
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("giohang/giohang.jsp");
        dispatcher.forward(request, response);
    }

    private void xoaGioHang(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(true);
        GioHang gioHang = null;
        Object o = session.getAttribute("gioHang");
        if (o != null) {
            gioHang = (GioHang) o;
        }else {
            gioHang = new GioHang();
        }
        int Masp = Integer.parseInt(request.getParameter("maspxoa"));
        gioHang.xoaMatHang(Masp);

        session.setAttribute("gioHang", gioHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("giohang/giohang.jsp");
        dispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(true);
//        GioHang gioHang = null;
//        Object o = session.getAttribute("gioHang");
//        if (o != null) {
//            gioHang = (GioHang) o;
//        }else {
//            gioHang = new GioHang();
//        }
//        int Masp = Integer.parseInt(request.getParameter("maspxoa"));
//        gioHang.xoaMatHang(Masp);
//
//        session.setAttribute("gioHang", gioHang);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("giohang.jsp");
//        dispatcher.forward(request, response);
    }
}
