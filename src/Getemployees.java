package jbdc.test;


import java.sql.*;


public class Getemployees {
	public static void main(String[] args) throws Exception{

	
	Connection myConn = null;
	CallableStatement myStmt = null;
	ResultSet myRs = null;
	
	
	try {
		//1.Get a connection to database
		myConn = DriverManager.getConnection("jbdc:mysql://localhost:3306/demo", "student" , "student");
		
		String theDepartment = "Engineering";
		
         // Prepare the stored procedure call			
		 
		myStmt = myConn.prepareCall("{call get_employees_for_department(?,?)}");
					
		//set the parameters
		myStmt.setString(1,  theDepartment);
		
		//call stored procedure
		System.out.println("Calling Stored procedure.  get_employees_for_department(' " + theDepartment + " ')");
		myStmt.execute();
		System.out.println("Finished calling stored procedure");
		
        //get the result set
		 
		myRs = myStmt.getResultSet();
		
		
		catch (Exception exc) {
			exc.printStackTrace();
		}

	
	finally {
	}

	}
	
	}
}

