package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseHeaderInfo")
public class ResponseHeader extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");

        // Set custom headers for demonstration
        response.setHeader("Custom-Header", "CustomHeaderValue");
        response.setHeader("Server", "CustomServer/1.0");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Response Header Information</title></head>");
        out.println("<body>");
        out.println("<h1>Response Header Information</h1>");

        // Display headers sent to the client
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");

        out.println("<tr><td>Content-Type</td><td>" + response.getContentType() + "</td></tr>");
        out.println("<tr><td>Custom-Header</td><td>" + response.getHeader("Custom-Header") + "</td></tr>");
        out.println("<tr><td>Server</td><td>" + response.getHeader("Server") + "</td></tr>");

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
