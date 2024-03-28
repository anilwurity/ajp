package test3;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/xyz")

public class ServletProgram3 extends HttpServlet {
	public void init() {}
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	pw.println("Welcome to servlet programming");
	}
	public void destroy() {}

}
