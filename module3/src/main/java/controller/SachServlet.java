package controller;

import dao.SachDAO;
import model.Sach;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SachServlet", urlPatterns = "/Sach")
public class SachServlet extends HttpServlet {
    private static final long seialVersionUID = 1L;
    private SachDAO sachDAO;
    public void init(){
        sachDAO = new SachDAO();
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
                    //deleteKH(request, response);
                    break;
                default:
                    listSach(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void listSach(HttpServletRequest request, HttpServletResponse response)  throws SQLException, IOException, ServletException{

        List<Sach> listSach = sachDAO.hienThiSach();
        request.setAttribute("listSach",listSach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listsach.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
