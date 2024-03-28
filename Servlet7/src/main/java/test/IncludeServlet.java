package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class IncludeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Before including TargetServlet content.</h2>");
        
        // Include content from TargetServlet
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/TargetServlet");
        dispatcher.include(request, response);
        
        out.println("<h2>After including TargetServlet content.</h2>");
    }
}
