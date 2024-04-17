import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/age")
public class AgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String ageParam = req.getParameter("age");

        if (ageParam.matches("\\D")) {
            writer.print("Only numbers!");
        } else {
            if (Integer.parseInt(ageParam) > 17) {
                writer.print("Adult");
            } else if (Integer.parseInt(ageParam) < 18 && Integer.parseInt(ageParam) > 0) {
                writer.print("Not adult");
            } else {
                writer.print("Error");
            }
        }
    }
}
