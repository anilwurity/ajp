package test;
import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Include the navigation menu
        RequestDispatcher dispatcher = request.getRequestDispatcher("/navigation");
        dispatcher.include(request, response);
        
        // Content for the Home page
        out.println("<h1>Welcome to the Home Page</h1>");
        out.println("<p>This is the content of the Home page.</p>");
    }
}
