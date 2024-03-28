package test;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VerifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Include header content before verifying credentials
        RequestDispatcher dispatcher = request.getRequestDispatcher("/IncludeServlet");
        dispatcher.include(request, response);
        
        if("admin".equals(username) && "admin".equals(password)) {
            // Forward to success page
            dispatcher = request.getRequestDispatcher("/success.html");
        } else {
            // Forward to failure page
            dispatcher = request.getRequestDispatcher("/failure.html");
        }

        dispatcher.forward(request, response);
    }
}


