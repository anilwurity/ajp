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
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Your Shopping Cart</h1>");
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            boolean hasProducts = false;
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("product")) {
                    hasProducts = true;
                    out.println("<p>Product ID: " + cookie.getValue() + " " +
                            "<a href='RemoveFromCartServlet?productID=" + cookie.getValue() + "'>Remove</a></p>");
                }
            }
            if (!hasProducts) {
                out.println("<p>Your cart is empty.</p>");
            }
        } else {
            out.println("<p>Your cart is empty.</p>");
        }
        out.println("<a href='index.html'>Continue Shopping</a>");
    }
}
