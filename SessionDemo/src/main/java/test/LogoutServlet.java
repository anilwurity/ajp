package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Invalidate the session
        HttpSession session = request.getSession(false); // Get existing session
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }

        // Generate response
        out.println("<html>");
        out.println("<head><title>Logout</title></head>");
        out.println("<body>");
        out.println("<h1>You have successfully logged out.</h1>");
        out.println("<p><a href='index.html'>Login Again</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
}
