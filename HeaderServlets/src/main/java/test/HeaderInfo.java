package test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Annotation-based configuration to access the servlet via "/HeaderInfo"
@WebServlet("/HeaderInfo")
public class HeaderInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Get the output stream to write HTML content
        PrintWriter out = response.getWriter();

        // Start building the HTML response
        out.println("<html>");
        out.println("<head><title>HTTP Request Headers</title></head>");
        out.println("<body>");
        out.println("<h1>HTTP Request Header Information</h1>");
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");

        // Get all header names using an enumeration
        Enumeration<String> headerNames = request.getHeaderNames();

        // Iterate over the headers and display each one
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<tr><td>" + headerName + "</td><td>" + headerValue + "</td></tr>");
        }

        // End the HTML response
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    // Handle POST requests as well, forwarding them to the same GET logic
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}
