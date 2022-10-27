package MyWebApp1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletdb
 */
@WebServlet("/servletdb")
public class servletdb extends HttpServlet {

	private static final long serialVersionUID = 1L;
	final String URL = "jdbc:sqlserver://localhost:1433;databaseName=EmpDB;encrpyt=true;trustServerCertificate=true;integratedSecurity=false";
	final String USER = "admin";
	final String PASSWORD = "12345678";
	final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	Connection conn = null;

	public void init() throws ServletException {

		// Database connection through Driver Manager
		try {
			//DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected..to employees");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(" Not Connected");
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			// Set the response content type and
			// get the PrintWriter object.
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			// Set up HTML table formatting for the output
			out.println("<html><body>");
			out.println("<h3>Employee Details</h3>");
			out.println("<table border=1><tr>" + "<td><b>E.No</b></td>" + "<td><b>Ename</b></td>"
					+ "<td><b>Mobile</b></td>" + "<td><b>Email</b></td>"
					+ "<td><b>Deptid</b></td></tr>");

			// Create JDBC statement object, construct
			// the SQL query and execute the query.
			Statement stmt = conn.createStatement();
			String sql = "select * from employee;";
			ResultSet rs = stmt.executeQuery(sql);

			// Loop through the result set to
			// retrieve the individual data items.
			while (rs.next()) {
				int eno = rs.getInt("eid");
				String ename = rs.getString("ename");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				int deptid = rs.getInt("deptid");

				out.println("<tr>" + "<td>" + eno + "</td>" + "<td>" + ename + "</td>" + "<td>" + mobile + "</td>"
						+ "<td>" + email + "</td>" + "<td>" + deptid + "</td>" + "</tr>");

			}
			out.println("</table>");
			out.println("<a href=/MyWebApp1/html/home.html>Click me</a></body></html>");
			
			// Close Result set, Statement
			// and PrintWriter objects.
			rs.close();
			stmt.close();
			out.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void destroy() {

		// Close connection object.
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

