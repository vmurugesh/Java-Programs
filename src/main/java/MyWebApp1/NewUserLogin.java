package MyWebApp1;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MyWebApp1.DBConnection;

/**
 * Servlet implementation class NewUserLogin
 */
@WebServlet("/NewUserLogin")
public class NewUserLogin extends GenericServlet {
	       
   
    public NewUserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		String uName = req.getParameter("username");
		String pWord = req.getParameter("password");
		String fName = req.getParameter("firstname");
		String lName = req.getParameter("lastname");
		String addr = req.getParameter("address");
		String phNo = req.getParameter("phone");
		String mailId = req.getParameter("mailid");
		try {
			Connection con = DBConnection.getCon();
			System.out.println("Connected.....");
			PreparedStatement ps = con
					.prepareStatement("insert into Users values(?,?,?,?,?,?,?,?)");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			ps.setString(3, fName);
			ps.setString(4, lName);
			ps.setString(5, addr);
			ps.setString(6, phNo);
			ps.setString(7, mailId);
			ps.setInt(8, 2);
			int k = ps.executeUpdate();
			System.out.println("Inserted....");
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("Sample.html");
				rd.include(req, res);
				pw.println("<h3 class='tab'>User Registered Successfully</h3>");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("userreg");
				rd.include(req, res);
				pw.println("Sorry for interruption! Register again");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
