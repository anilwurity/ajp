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
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String productID = request.getParameter("productID");

        if (productID != null) {
            // Create a cookie for the product
            Cookie productCookie = new Cookie("product" + productID, productID);
            productCookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(productCookie);

            out.println("<h3>Product " + productID + " added to your cart.</h3>");
            out.println("<a href='index.html'>Continue Shopping</a><br>");
            out.println("<a href='ViewCartServlet'>View Cart</a>");
        } else {
            out.println("<h3>No product selected.</h3>");
        }
    }
}
