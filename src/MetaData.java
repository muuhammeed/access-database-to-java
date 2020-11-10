import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaData {

	public static void main(String[] args) throws SQLException{
		
		Connection myConn = null;
		try {
			// Get a conncetion to database
			myConn = DriverManager.getConnection("jbdc:mysql://localhost:3306/demo", "student" , "student");
			
			//get metadata
			DatabaseMetaData databaseMetaData = myConn.getMetaData();
			
			//Display info about database
			System.out.println("Product name:" + databaseMetaData.getDriverName());
			System.out.println("Product verison:" + databaseMetaData.getDriverVersion());
            
			//Display info about JDBC Driver
			System.out.println("JDBC Driver name:" +  databaseMetaData.getDriverName());
			System.out.println("JDBC Driver verison:" +  databaseMetaData.getDriverVersion());

			
		} catch (Exception exc) {
			exc.printStackTrace();
			
		} finally {
			close(myConn);
		}
	}

	private static void close(Connection myConn) {
		// TODO Auto-generated method stub
		
	}		
}

