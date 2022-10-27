import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", value= "/")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 121L;
    public Hello() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		out.print("<html><body>");
		out.print("<h3>Hello Servlet</h3><h1>");
		out.print(serialVersionUID+"</h1>");
		out.print("</body></html>");
		
	}

}
