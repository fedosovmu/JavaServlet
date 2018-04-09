import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/Servlet", urlPatterns = "/Servlet")
public class Servlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double numA;
        double numB;
        String out;
        Double result;

        try {
            numA = Double.parseDouble(request.getParameter("numA"));
            numB = Double.parseDouble(request.getParameter("numB"));

            String method = request.getParameter("method");
            switch (method) {

                case "+" : {
                    result = numA + numB;
                    out = result.toString();
                }
                break;
                case "-" : {
                    result = numA - numB;
                    out = result.toString();
                }
                break;
                case "*" : {
                    result = numA * numB;
                    out = result.toString();
                }
                break;
                case "/" : {
                    result = numA / numB;
                    out = result.toString();
                }
                break;
                default: {
                    out = "Wrong simbol of action";
                }

            }

        } catch (NumberFormatException e) {
            out = ("Wrong number format");
        } finally {

        }
        PrintWriter printWriter = response.getWriter();
        printWriter.println(out);
        printWriter.close();
    }

}
