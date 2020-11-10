import java.sql.*;

/**
 * *
 * *@author www.luv2code.com
 * 
 */
public class jbdctrst {
	
	public static void main(String[] args) throws SQLException{
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
		try {
			//1.Get a connection to database
			myConn = DriverManager.getConnection("jbdc:mysql://localhost:3306/demo", "student" , "student");
			
			String theDepartment = "Engineering";
			int theIncreaseAmount = 10000;
			// show salaries BEFORE
			
			System.out.println("Salaries BEFORE/n");
			showSalaries(myConn, theDepartment);
			
			// 3.Execute SQL query
			myStmt = myConn.prepareCall("{call increase_salaries_for_department(?,?}");
			
			//set the parameters
			myStmt.setString(1,  theDepartment);
			myStmt.setDouble(2,  theIncreaseAmount);
			
			//call stored procedure
			System.out.println("/n/nCalling Stored procedure.  increase_salaries_for_department(' " + theDepartment + " ')");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
			//Show salaries AFTER
			
			System.out.println("/n/nSalaries AFTER/n");
			showSalaries(myConn, theDepartment);}
			
			catch (Exception exc) {
				exc.printStackTrace();
			}
	
		
		finally {
			 close(myConn,myStmt, null);
		}
	}

	private static void showSalaries(Connection myConn, String theDepartment) {
		// TODO Auto-generated method stub
		
	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		
	}

		// TODO Auto-generated method stub
		
	}
   

	

		 
		
				
	

