package controller;

import dao.NhanVienDAO;
import model.NhanVien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", urlPatterns = "/NhanVien")
public class NhanVienServlet extends HttpServlet {
    private static final long seialVersionUID = 1L;
    private NhanVienDAO nhanVienDAO;

    public void init(){
        nhanVienDAO = new NhanVienDAO();
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
                    //showNewForm(request, response);
                    break;
                case "edit":
                    //showEditForm(request, response);
                    break;
                case "delete":
                    //deleteUser(request, response);
                    break;
                default:
                    listNhanVien(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }

    }

    private void listNhanVien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        List<NhanVien> listNhanVien = nhanVienDAO.selectAllNhanVien();
        request.setAttribute("listNhanVien",listNhanVien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listnhanvien.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
