
import java.awt.Window.Type;
import java.sql.*;

/**
 * *
 * *@author www.luv2code.com
 * 
 */
public class GreetTheDepartment {
	public static void main(String[] args) throws Exception{
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
		try {
			//1.Get a connection to database
			myConn = DriverManager.getConnection("jbdc:mysql://localhost:3306/demo", "student" , "student");
			
			String theDepartment = "Engineering";
			
             // Prepare the stored procedure call			
			 
			myStmt = myConn.prepareCall("{call greet_the_department(?)}");
						
			//set the parameters
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1,  theDepartment);
			
			//call stored procedure
			System.out.println("Calling Stored procedure.  greet_the_department(' " + theDepartment + " ')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
            //get the value of the INOUT paramter
			
			String theResult = myStmt.getString(1);
			System.out.println("/nThe result = " + theResult);
			
			
			
			catch (Exception exc) {
				exc.printStackTrace();
			}
	
		
		finally {
			 close(myConn,myStmt, null);
		}
	

	

	

		 
		
				
	



}
