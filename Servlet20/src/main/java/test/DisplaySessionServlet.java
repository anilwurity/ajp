package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplaySessionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get session attribute
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Send response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (username != null) {
            out.println("<h2>Hello, " + username + "!</h2>");
        } else {
            out.println("<h2>No session attribute found!</h2>");
        }
        out.println("</body></html>");
    }
}
