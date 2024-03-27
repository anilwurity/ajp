package test;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		Cookie ck1=new Cookie("ckemail",email);
		Cookie ck2=new Cookie("ckpass",pass);
		resp.addCookie(ck1);
		resp.addCookie(ck2);
		resp.sendRedirect("profile");
		
	}

}
