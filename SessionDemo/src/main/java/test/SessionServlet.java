package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user credentials (for demonstration purposes, use static validation)
        if ("admin".equals(username) && "password".equals(password)) {
            // Create or retrieve the session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Generate response
            out.println("<html>");
            out.println("<head><title>Session Demo</title></head>");
            out.println("<body>");
            out.println("<h1>Welcome, " + username + "</h1>");
            out.println("<p>Session ID: " + session.getId() + "</p>");
            out.println("<p><a href='LogoutServlet'>Logout</a></p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
            out.println("<head><title>Login Failed</title></head>");
            out.println("<body>");
            out.println("<h1>Invalid Credentials!</h1>");
            out.println("<p><a href='index.html'>Try Again</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response); // Handle GET requests the same as POST
    }
}
