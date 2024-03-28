package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set a cookie
        Cookie cookie = new Cookie("username", "john_doe");
        cookie.setMaxAge(24 * 60 * 60); // Cookie expires in 24 hours
        response.addCookie(cookie);

        // Retrieve cookies
        Cookie[] cookies = request.getCookies();
        String username = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    username = c.getValue();
                    break;
                }
            }
        }

        // Send response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (username != null) {
            out.println("<h2>Hello, " + username + "!</h2>");
        } else {
            out.println("<h2>Welcome, Guest!</h2>");
        }
        out.println("</body></html>");
    }
}
