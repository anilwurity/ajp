package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String productID = request.getParameter("productID");

        if (productID != null) {
            // Create a cookie with the same name and set its max age to 0
            Cookie productCookie = new Cookie("product" + productID, "");
            productCookie.setMaxAge(0);
            response.addCookie(productCookie);

            out.println("<h3>Product " + productID + " removed from your cart.</h3>");
        } else {
            out.println("<h3>No product specified for removal.</h3>");
        }
        out.println("<a href='ViewCartServlet'>Back to Cart</a><br>");
        out.println("<a href='index.html'>Continue Shopping</a>");
    }
}