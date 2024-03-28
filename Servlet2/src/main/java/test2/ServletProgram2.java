package test2;
import  java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet("/pqr")

public class ServletProgram2 extends HttpServlet {
	
	public void init() {}
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
	pw.println("Welcome to servlet programming");
	}
	public void destroy() {}

}
