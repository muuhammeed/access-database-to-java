package jbdc.test;


import java.sql.*;

public class GetCountForDepartment {
public static void main(String[] args) throws Exception{
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
		try {
			//1.Get a connection to database
			myConn = DriverManager.getConnection("jbdc:mysql://localhost:3306/demo", "student" , "student");
			
			String theDepartment = "Engineering";
			
             // Prepare the stored procedure call			
			 
			myStmt = myConn.prepareCall("{call get_count_fot_department(?,?)}");
						
			//set the parameters
			myStmt.setString(1,  theDepartment);
			myStmt.registerOutParameter(2, Types.VARCHAR);

			
			//call stored procedure
			System.out.println("Calling Stored procedure.  get_count_for_department(' " + theDepartment + " ')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
            //get the value of the INOUT paramter
			
			int theCount = myStmt.getInt(2);
			System.out.println("/nThe count = " + theCount);
			
			
			
			catch (Exception exc) {
				exc.printStackTrace();
			}
	
		
		finally {
			 close(myConn,myStmt, null);
		}
	
		
}