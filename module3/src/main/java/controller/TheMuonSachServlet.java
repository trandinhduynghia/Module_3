package controller;

import dao.PhongTroDAO;
import model.HocSinh;
import model.Sach;
import model.TheMuonSach;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TheMuonSachServlet", urlPatterns = "/TheMuonSach")
public class TheMuonSachServlet extends HttpServlet {
    private static final long seialVersionUID = 1L;
    private PhongTroDAO theMuonSachDAO;
    public void init(){
        theMuonSachDAO = new PhongTroDAO();
    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
////                case "create":
////                    showNewForm(request, response);
////                    break;
////                case "edit":
////                    editTheMuonSach(request, response);
////                    break;
////                case "delete":
////                    //deleteKH(request, response);
////                    break;
////                default:
////                    listTheMuonSach(request, response);
////                    break;
//            }
//        }catch (SQLException ex){
//            throw new ServletException(ex);
//        }
//    }

//    private void listTheMuonSach(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException{
//        String q =  "";
//        if (request.getParameter("q") != null) {
//            q = request.getParameter("q");
//        }
//        String q1 =  "";
//        if (request.getParameter("q1") != null) {
//            q1 = request.getParameter("q1");
//        }
//        List<TheMuonSach> theMuonSachs = theMuonSachDAO.hienThiTheMuonSach(q, q1);
//        request.setAttribute("theMuonSachs",theMuonSachs);
//
//        List<Sach> sachs = theMuonSachDAO.hienThiSach();
//        request.setAttribute("sachs", sachs);
//
//        List<HocSinh> hocSinhs = theMuonSachDAO.hienThiHS();
//        request.setAttribute("hocSinhs", hocSinhs);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
//        dispatcher.forward(request, response);
//    }

//    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        List<Sach> sachs = theMuonSachDAO.hienThiSach();
//        request.setAttribute("sachs", sachs);
//
//        List<HocSinh> hocSinhs = theMuonSachDAO.hienThiHS();
//        request.setAttribute("hocSinhs", hocSinhs);
//
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("them.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void editTheMuonSach(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int MaMuonSach = Integer.parseInt(request.getParameter("MaMuonSach"));
//        theMuonSachDAO.capNhatTheMuonSach(MaMuonSach);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        try {
//            switch (action) {
//                case "create":
//                    insertKH(request, response);
//                    break;
//                case "edit":
//                    //updateKH(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }
//    }

//    private void insertKH(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int MaSach = Integer.parseInt(request.getParameter("MaSach"));
//        int MaHS = Integer.parseInt(request.getParameter("MaHS"));
//        String TrangThai = request.getParameter("TrangThai");
//        String NgayMuon = request.getParameter("NgayMuon");
//        String NgayTra = request.getParameter("NgayTra");
//        TheMuonSach theMuonSach = new TheMuonSach(MaSach, MaHS, TrangThai, NgayMuon, NgayTra);
//
//        Map<String, String> errorMap = new HashMap<>();
//        if (0 == theMuonSach.getMaSach()) {
//            errorMap.put("MaSach", "Mã sách không được để trống");
//        }
//        if (0 == theMuonSach.getMaHocSinh()) {
//            errorMap.put("MaHS", "Mã HS không được để trống");
//        }
//        if ("".equals(theMuonSach.getTrangThai())) {
//            errorMap.put("TrangThai", "Trạng thái không được để trống");
//        }
//        if ("".equals(theMuonSach.getNgayMuon())) {
//            errorMap.put("NgayMuon", "Ngày mượn không được để trống");
//        }
//        if ("".equals(theMuonSach.getNgayTra())) {
//            errorMap.put("NgayTra", "Ngày trả không được để trống");
//        }
//
//        // nêu không có lỗi thì cho lưu vào db
//        if (errorMap.isEmpty()) {
//            theMuonSachDAO.themTheMuonSach(theMuonSach);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
//            dispatcher.forward(request, response);
//        }else {
//            List<Sach> sachs = theMuonSachDAO.hienThiSach();
//            request.setAttribute("sachs", sachs);
//
//            List<HocSinh> hocSinhs = theMuonSachDAO.hienThiHS();
//            request.setAttribute("hocSinhs", hocSinhs);
//
//            request.setAttribute("errorMap", errorMap);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("them.jsp");
//            dispatcher.forward(request, response);
//        }
//    }
}
