package controller;

import dao.AccountDAO;
import model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SigninServlet", urlPatterns = "/Signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/signup.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String repassword = request.getParameter("repass");
        if(!password.equals(repassword)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("user/signup.jsp");
            dispatcher.forward(request, response);
        }else{
            AccountDAO dao = new AccountDAO();
            Account a = dao.checkAccountExist(username);
            if(a == null){
                dao.signup(username,password);
                response.sendRedirect("users");
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/signup.jsp");
                dispatcher.forward(request, response);
            }
        }

    }
}
