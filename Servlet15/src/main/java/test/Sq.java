package test;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class Sq extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter out=res.getWriter();
		//int num3=Integer.parseInt((String)(req.getAttribute("num3")));
		//HttpSession session=req.getSession();
		//int num3=(int)session.getAttribute("num3");
		
		int num3=0;
		Cookie cookies[]=req.getCookies();
		for(Cookie c:cookies)
		{
			if(c.getName().equals("num3"))
				num3=Integer.parseInt(c.getValue());
		}
		
		out.println("result is"+num3*num3);
	}

}
