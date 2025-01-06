package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayFormData")
public class DisplayFormData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Setting the response type
        response.setContentType("text/html");

        // Reading form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String desi=request.getParameter("designation");

        // Sending response
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Form Data</title></head>");
        out.println("<body>");
        out.println("<h1>Submitted Form Data</h1>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Age:</strong> " + age + "</p>");
        out.println("<p><strong> Deisgnation </strong>"+ desi+"<p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response); // Handle GET requests the same as POST
    }
}

