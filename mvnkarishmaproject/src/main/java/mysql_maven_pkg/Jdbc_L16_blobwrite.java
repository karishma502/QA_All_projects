package mysql_maven_pkg;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


//Viewing blob in mysql
// https://exceptionshub.com/how-can-i-directly-view-blobs-in-mysql-workbench.html

public class Jdbc_L16_blobwrite {

	public static void main(String[] args) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		FileInputStream input = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "student", "student@123");

			// 2. Prepare statement
			String sql = "update employees set resume=? where email='john.doe@foo.com'";
			myStmt = myConn.prepareStatement(sql);
			
			// 3. Set parameter for resume file name
			
			//Added the below 2 lines of code
			//The folder "Excel" needs to be present under src
			//and should contain the file "sample_resume.pdf"
			//Use the program blobwrite2 - to add a xml file to the DB
			   String filePath = System.getProperty("user.dir")+"\\src\\Excel";
			   String fileName="sample_resume.pdf";
			   File theFile =    new File(filePath+"\\"+fileName);

			
			//File theFile = new File("sample_resume.pdf");
			input = new FileInputStream(theFile);
			myStmt.setBinaryStream(1, input);
			
			System.out.println("Reading input file: " + theFile.getAbsolutePath());
			
			// 4. Execute statement
			System.out.println("\nStoring resume in database: " + theFile);
			System.out.println(sql);
			
			myStmt.executeUpdate();
			
			System.out.println("\nCompleted successfully!");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {			
			if (input != null) {
				input.close();
			}
			
			close(myConn, myStmt);			
		}
	}

	private static void close(Connection myConn, Statement myStmt)
			throws SQLException {

		if (myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

}
