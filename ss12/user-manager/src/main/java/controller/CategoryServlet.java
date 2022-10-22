package controller;

import dao.ProductDAO;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet",  urlPatterns = "/Category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lay gia tri co ten bien id o trang product
        String id = request.getParameter("id");
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getProductByCateID(id);

        // dua list vao list cua trang product
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/product.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
