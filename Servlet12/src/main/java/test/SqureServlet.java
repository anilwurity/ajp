package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SqureServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int k=(int)req.getAttribute("k");
		k=k*k;
		PrintWriter out=res.getWriter();
		out.println("square of a number is"+k);
	}

}
