package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddServlet extends HttpServlet{

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		int k=i+j;
		PrintWriter out=res.getWriter();
		out.println("Result is"+k);
		req.setAttribute("k",k);
		RequestDispatcher rd=req.getRequestDispatcher("/sq");
		rd.forward(req,res);
		
		System.out.println("Result is"+k);
	}
	
}
