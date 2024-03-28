package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class ReadCookiesAndSessionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set content type to HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Read session information
        HttpSession session = request.getSession(false);
        String sessionAttribute = null;
        if (session != null) {
            sessionAttribute = (String) session.getAttribute("sessionAttribute");
        }
        
        // Read cookie information
        Cookie[] cookies = request.getCookies();
        String cookieValue = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("TestCookie".equals(cookie.getName())) {
                    cookieValue = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8.toString());
                    break;
                }
            }
        }

        // Write some HTML content
        out.println("<html><body>");
        out.println("<h2>Read Session and Cookies</h2>");
        out.println("Session Attribute: " + sessionAttribute + "<br>");
        out.println("Cookie Value: " + cookieValue);
        out.println("</body></html>");
    }
}