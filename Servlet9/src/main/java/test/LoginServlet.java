package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<form action='VerifyServlet' method='POST'>" +
                                      "<input type='text' name='username' placeholder='Username'/>" +
                                      "<input type='password' name='password' placeholder='Password'/>" +
                                      "<input type='submit' value='Login'/>" +
                                      "</form>");
    }
}
