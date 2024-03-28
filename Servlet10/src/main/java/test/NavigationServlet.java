package test;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/navigation")
public class NavigationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print("<nav>" +
                                   "<a href='/home'>Home</a> | " +
                                   "<a href='/about'>About</a> | " +
                                   "<a href='/contact'>Contact</a>" +
                                   "</nav>");
    }
}
