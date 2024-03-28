package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Add extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		int num1=Integer.parseInt(req.getParameter("first"));
		int num2=Integer.parseInt(req.getParameter("second"));
		int num3=num1+num2;
		//req.setAttribute("num3", num3+"");
		//RequestDispatcher rd=req.getRequestDispatcher("/Sq");
		//rd.forward(req, res);
		//HttpSession session=req.getSession();
		//session.setAttribute("num3", num3);
		
		Cookie cookie=new Cookie("num3",num3+"");
		res.addCookie(cookie);
		
		
		res.sendRedirect("Sq"
				+ "");
		
	}

}
