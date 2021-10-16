package mysql_maven_pkg;

import java.sql.*;


public class Jdbc_temp3 {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://db4free.net:3306/tqtest";
		String user = "student";		
		String pass = "student@123";

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// 2. Create a statement
			myStmt = myConn.createStatement();

			// 3. Insert a new employee
			System.out.println("Inserting a new employee to database\n");
			
			int rowsAffected = myStmt.executeUpdate(
				"insert into employees (first_name) " + 
				"values ('Amit')");
			
			// 4. Verify this by getting a list of employees
			myRs = myStmt.executeQuery("select * from employees ");
			
			// 5. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("first_name"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}

}

