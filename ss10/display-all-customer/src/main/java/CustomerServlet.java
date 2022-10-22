import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns = "/Danhsachkhachhang")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ;Customer[] customers = {
                new Customer("Mai Văn Hoàn", "20-8-1983", "Hà Nội","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),
                new Customer("Nguyễn Văn Nam", "21-08-1983", "Bắc Giang","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),
                new Customer("Nguyễn Thái Hòa", "22-08-1983", "Nam Định","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),
                new Customer("Trần Đăng Khoa", "17-08-1983", "Hà Tây","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),
                new Customer("Nguyễn Đình Thi", "19-08-1983", "Hà Nội","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),

        };
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ;Customer[] customers = {
                new Customer("Mai Văn Hoàn", "20-8-1983", "Hà Nội","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),
                new Customer("Nguyễn Văn Nam", "21-08-1983", "Bắc Giang","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),
                new Customer("Nguyễn Thái Hòa", "22-08-1983", "Nam Định","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),
                new Customer("Trần Đăng Khoa", "17-08-1983", "Hà Tây","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),
                new Customer("Nguyễn Đình Thi", "19-08-1983", "Hà Nội","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR2Dq2N4LnM19JTpHWCOw1X8M7kdUea3DSjiA&usqp=CAU"),

        };
        request.setAttribute("customers", customers);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
