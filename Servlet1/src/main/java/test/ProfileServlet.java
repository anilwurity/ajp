package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
@WebServlet("/profile")

public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] ck=req.getCookies();
		if(ck==null)
		{
			resp.sendRedirect("index.html");
		}
		else
		{
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<h1>Email="+ck[0].getValue()+"</h1>");
			out.println("<h1> Password="+ck[1].getValue()+"</h1>");
			out.println("<a href='logout'>Logout</a>");
			
		}
	}
	

}
