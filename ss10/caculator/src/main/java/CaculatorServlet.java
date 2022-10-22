import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CaculatorServlet", value = "/calculate")
public class CaculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        char oparator = request.getParameter("opearator").charAt(0);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try{
            float result = Caculator.caculate(firstOperand, secondOperand, oparator);
            writer.println(firstOperand + " "+oparator+" "+secondOperand+" = "+result);
        }catch (Exception e){
            writer.println(e.getMessage());
        }
        writer.println("</html>");



    }
}
