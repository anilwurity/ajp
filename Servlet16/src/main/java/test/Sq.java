package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Sq extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		//int sqnum3=Integer.parseInt((String)(req.getAttribute("snum3")));
		HttpSession ses=req.getSession();
		int sqnum3=Integer.parseInt((String)(ses.getAttribute("sesnum3")));
		PrintWriter out=res.getWriter();
		out.println("Square of number is"+sqnum3*sqnum3);
	}

}
