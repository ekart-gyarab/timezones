import javax.servlet.*;
import javax.servlet.http.*;

import org.w3c.dom.Text;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@WebServlet("/zones")
public class MyServlet2 extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String input = request.getParameter("input");
        String result = "";

        try {
            ZoneId zone = ZoneId.of(input);
            ZonedDateTime now = ZonedDateTime.now(zone);
            result = now.toString();
        } catch (Exception e) {
            System.out.println(e);
            result = "Zone not found";
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        out.println(
            "<html><body>" + 
                "<h1>Timezone app</h1>" +
                "<form method='POST' action='zones'><input type='text' name='input'></input>" +
                "<input type='submit' value='Submit'></form>" +
                "<p>" + result + "</p>" +
            "</body></html>"
            );
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      doGet(request, response);
   }
}