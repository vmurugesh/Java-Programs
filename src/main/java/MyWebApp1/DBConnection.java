package MyWebApp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con;

	private DBConnection() {
	}
	
	static {

		
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Connecting!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			
		    con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EmpDB;encrpyt=true;trustServerCertificate=true;integratedSecurity=false","admin","12345678");
		    System.out.println("Connected!!!!");
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}// End of static block

	public static Connection getCon() {
		return con;
	}
}
