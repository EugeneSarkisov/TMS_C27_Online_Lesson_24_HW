import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/age_with_post")
public class AgeWithPostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            sb.append(line);
        }
        String postParam = sb.toString();

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> map = mapper.readValue(postParam, new TypeReference<Map>() {
        });

        if (map.get("age") > 17) {
            writer.print("Adult");
        } else if (map.get("age") < 18 && map.get("age") > 0) {
            writer.print("Not adult");
        } else {
            writer.print("Error");
        }
    }
}

