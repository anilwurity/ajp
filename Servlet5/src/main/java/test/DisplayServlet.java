package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayServlet extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	String name=req.getParameter("name");
	pw.println("<html><body>");
	pw.println("name="+name);
	pw.println("</body></html>");
	}
}
