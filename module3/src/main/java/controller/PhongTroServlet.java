package controller;

import dao.PhongTroDAO;
import model.*;
import validate.Validation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PhongTroServlet", urlPatterns = "/PhongTro")
public class PhongTroServlet extends HttpServlet {
    private static final long seialVersionUID = 1L;
    private PhongTroDAO phongTroDAO;
    public void init(){
        phongTroDAO = new PhongTroDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    //editTheMuonSach(request, response);
                    break;
                case "delete":
                    deletePhongTro(request, response);
                    break;
                default:
                    listPhongTro(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("them.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePhongTro(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int MaPhongTro = Integer.parseInt(request.getParameter("MaPhongTro"));
        phongTroDAO.xoaPhongTro(MaPhongTro);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void listPhongTro(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException{
        String q =  "";
        if (request.getParameter("q") != null) {
            q = request.getParameter("q");
        }
        String q1 =  "";
        if (request.getParameter("q1") != null) {
            q1 = request.getParameter("q1");
        }
        String q2 =  "";
        if (request.getParameter("q2") != null) {
            q2 = request.getParameter("q2");
        }
        List<PhongTro> phongTros = phongTroDAO.hienThiPhongTro(q, q1, q2);
        request.setAttribute("phongTros",phongTros);

        List<HinhThucThanhToan> hinhThucThanhToans = phongTroDAO.hienThiHinhThucThanhToan();
        request.setAttribute("hinhThucThanhToans", hinhThucThanhToans);


        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
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
                    insertKH(request, response);
                    break;
                case "edit":
                    //updateKH(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertKH(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int MaPhongTro = Integer.parseInt(request.getParameter("MaPhongTro"));
        String TenNguoiThueTro = request.getParameter("TenNguoiThueTro");
        String Sdt = request.getParameter("Sdt");
        String NgayBatDau = request.getParameter("NgayBatDau");
        int HinhThucThanhToan = Integer.parseInt(request.getParameter("HinhThucThanhToan"));
        String GhiChu = request.getParameter("GhiChu");
        PhongTro phongTro = new PhongTro(TenNguoiThueTro, Sdt, NgayBatDau, HinhThucThanhToan, GhiChu);

        Map<String, String> errorMap = new HashMap<>();
        if ("".equals(phongTro.getTenNguoiThueTro())) {
            errorMap.put("HoTen", "Họ tên không được để trống");
        }else if(!Validation.checkTen(phongTro.getTenNguoiThueTro())){
            errorMap.put("HoTen","Họ tên không đúng định dạng");
        }

        if ("".equals(phongTro.getSdt())) {
            errorMap.put("SDT", "SDT không được để trống");
        }else if(!Validation.checkSDT(phongTro.getSdt())){
            errorMap.put("SDT","SDT không đúng định dạng");
        }

        if ("".equals( phongTro.getNgayBatDau())) {
            errorMap.put("NgayBatDau", "Ngày bắt đầu không được để trống");
        }

        if (0 == phongTro.getHinhThucThanhToan()) {
            errorMap.put("HinhThuc", "Hình thức thanh toán không được để trống");
        }

        if ("".equals( phongTro.getGhiChu())) {
            errorMap.put("GhiChu", "Ghi chú không được để trống");
        }



        // nêu không có lỗi thì cho lưu vào db
        if (errorMap.isEmpty()) {
            phongTroDAO.themPhongTro(phongTro);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
            dispatcher.forward(request, response);
        }else {
            request.setAttribute("errorMap", errorMap);
            RequestDispatcher dispatcher = request.getRequestDispatcher("them.jsp");
            dispatcher.forward(request, response);
        }
    }
}
