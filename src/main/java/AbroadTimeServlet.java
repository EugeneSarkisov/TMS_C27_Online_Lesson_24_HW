import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@WebServlet("/AbroadTime/*")
public class AbroadTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");
        String action = pathParts[1];

        if("washington".equals(action)){
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.print(ZonedDateTime.now(ZoneId.of("-05:00")));
        } else if ("beijing".equals(action)) {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.print(ZonedDateTime.now(ZoneId.of("Asia/Shanghai")));
        }
    }
}
