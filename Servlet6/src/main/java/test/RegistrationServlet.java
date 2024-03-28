package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegistrationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password"); // In a real application, handle passwords securely!

        // Display the information
        out.println("<html><body>");
        out.println("<h2>Registration Details</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Password: " + password + "</p>"); // Displaying passwords is unsafe in real applications.
        out.println("</body></html>");
    }
}
