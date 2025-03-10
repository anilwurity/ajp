package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

@WebServlet("/IncludeServlet")
public class IncludeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<h2>Main Servlet Content</h2>");
        
        // Including content from OtherServlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("OtherServlet");
        dispatcher.include(request, response);
        
        out.println("<h3>End of Main Servlet</h3>");
    }
}
