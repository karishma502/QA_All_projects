package mysql_maven_pkg;
import java.sql.*;

/*
 * 
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.26</version>
</dependency>

 * 
 */


// JDBC connection issue - https://javarevisited.blogspot.com/2016/09/javasqlsqlexception-no-suitable-driver-mysql-jdbc-localhost.html
// download the jar from the relevant link and include in the build path

public class Jdbc_temp {

	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		int myRs = 0;
		
		String dbUrl = "jdbc:mysql://db4free.net:3306/tqtest";
		String user = "student";		
		String pass = "student@123";

		try {
			// 1. Get a connection to database
			System.out.println("Connection is:"+myConn);
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			System.out.println("Connection is:"+myConn);
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			String query="CREATE TABLE `employees` (`id` int(11) NOT NULL AUTO_INCREMENT,"+
					  "`first_name` varchar(64) DEFAULT NULL, PRIMARY KEY (`id`)"+
					") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";
			
			// 3. Execute SQL query
			myRs = myStmt.executeUpdate(query);
			/*
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}*/
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//if (myRs != null) {
				//myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}


