package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProdureServlet", urlPatterns = "/Product")
public class ProdureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //b1: lấy dữ liệu từ form dao
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.getAllProduct();
        //b2: set data to jsp
        request.setAttribute("list",list);

        // list danh muc
        CategoryDAO dao1 = new CategoryDAO();
        List<Category> list1 = dao1.getAllCategory();
        request.setAttribute("list1",list1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("user/product.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
