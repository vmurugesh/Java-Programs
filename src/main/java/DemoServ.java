import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet(name = "hello", value= "/demo")
public class DemoServ extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String name=req.getParameter("name");
pw.println("Welcome "+name);
}}
