package controller;

import dao.AccountDAO;
import model.Account;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        AccountDAO accountDAO = new AccountDAO();
        Account a = accountDAO.login(username, password);
        if(a == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/login.jsp");
            dispatcher.forward(request, response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("acc", a);
            // thời gian giũ session tài khoản
            session.setMaxInactiveInterval(10);
            response.sendRedirect("users");
        }

    }
}
