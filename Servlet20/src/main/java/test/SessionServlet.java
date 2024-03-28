package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user name from form
        String name = request.getParameter("name");

        // Set session attribute
        HttpSession session = request.getSession();
        session.setAttribute("username", name);

        // Send response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Session attribute 'username' set successfully!</h2>");
        out.println("<a href='DisplaySession'>Display Session Attribute</a>");
        out.println("</body></html>");
    }
}
