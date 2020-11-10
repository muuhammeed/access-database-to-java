import java.sql.*;
import java.util.Scanner;



public class TransctionDemo {
	
	public static void main(String[] args) throws SQLException {
	
	Connection myConn = null;
	Statement myStmt = null;
	
	try {
		// Get a conncetion to database
		myConn = DriverManager.getConnection("jbdc:mysql://localhost:3306/demo", "student" , "student");
        
		//Turn off aut commit
		
		myConn.setAutoCommit(false);
		
		//show salaries BEFORE
		
		System.out.println("Salaries BEFORE/n");
		showSalaries(myConn, "HR");
		showSalaries(myConn, "Engineering");
		
		//Transcation step 1 :delete all r employees
		
		myStmt = myConn.createStatement();
		myStmt.executeUpdate("delete from employees where department='HR'");
		
		//Transcton step 2 : set salaries to 3000 for all engineering
		//employees
		myStmt.executeUpdate("udate employees set salary=300000 where department='Engineering'");
		
		System.out.println("/n>> Transaction steps are ready./n");
		
		//Ask user if it is okay to save
		boolean ok = askUserIFOkToSave();
		
		if (ok) {
			//STORE IN DATABASE
			myConn.commit();
			System.out.println("/n>> Transction COMITTED./n");
		
		} else {
			
			//discard
			myConn.rollback();
			System.out.println("/n>> Transction ROLLED BACK./n");
			
		}
		//show salaries after
		System.out.println("Salaries AFTER/n");
		showSalaries(myConn, "HR");
		showSalaries(myConn,"Engineering");
		
		catch (Exception exc) {
			exc.printStackTrace();
	}
	finally {
		
	}
	}
	
		
		
			
	

}

	private static boolean askUserIFOkToSave() {
		// TODO Auto-generated method stub
		return false;
	}

	private static void showSalaries(Connection myConn, String string) {
		// TODO Auto-generated method stub
		
	}
}
