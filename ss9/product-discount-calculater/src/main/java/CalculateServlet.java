import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculateServlet", value = "/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sanPham = request.getParameter("sanpham");
        double price = Float.parseFloat(request.getParameter("price"));
        double discount = Float.parseFloat(request.getParameter("discount"));

        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount;

        PrintWriter writer = response.getWriter();
        writer.println("<html");
        writer.println("<h2>Product Description: " + sanPham +"</h2>");
        writer.println("<h2>Price: " + price +"</h2>");
        writer.println("<h2>Discount Percent: " + discount+"</h2>");
        writer.println("<h2>Discount Amount: " + discountAmount+"</h2>");
        writer.println("<h2>Discount Price: " + discountPrice+ "</h2>");
        writer.println("</html>");

    }
}
