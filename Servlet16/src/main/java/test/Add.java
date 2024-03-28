package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Add extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		int snum1=Integer.parseInt(req.getParameter("num1"));
		int snum2=Integer.parseInt(req.getParameter("num2"));
		int snum3=snum1+snum2;
		req.setAttribute("snum3", snum3+"");
		//RequestDispatcher rd=req.getRequestDispatcher("Sq");
		//rd.forward(req, res);
		
		HttpSession ses=req.getSession();
		ses.setAttribute("sesnum3", snum3+"");
		res.sendRedirect("Sq");
	}

}
