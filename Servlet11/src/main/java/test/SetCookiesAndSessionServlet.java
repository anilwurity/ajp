package test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SetCookiesAndSessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Create a session for this user
        HttpSession session = request.getSession(true);
        session.setAttribute("sessionAttribute", "This is a session attribute");

        // Create a cookie
        Cookie cookie = new Cookie("TestCookie", "This is a cookie");
        // Set expiry time to 60 seconds
        cookie.setMaxAge(60);
        // Add cookie to response
        response.addCookie(cookie);

        // Write some HTML content
        out.println("<html><body>");
        out.println("<h2>Session and Cookie Set</h2>");
        out.println("<a href='readCookiesAndSession'>Read Cookies and Session</a>");
        out.println("</body></html>");
    }
}
