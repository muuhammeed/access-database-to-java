package jbdc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetDemo {
	
public static void main(String[] args) throws SQLException{
		
		Connection myConn = null;
		Statment myStmt = null;
		ResultSet my Rs = null;

		try {
			// Get a conncetion to database
						myConn = DriverManager.getConnection("jbdc:mysql://localhost:3306/demo", "student" , "student");
						
			//Run query 
						myStmt = myConn.createStatement();
						Object myRs = myStmt.executeQuery("select id, last_name, first_name, salary from employee");
			//get result set metadata
			
						ResultSetMetaData rsMetaData =  myRs.getMetaData();
						
			//Display info 
				int columnCount = rsMetaData.getColumnCount();
				System.out.println("Column count: " + columnCount + "/n");
				
				for (int column=1; column<= columnCount; column++) {
					
					System.out.println("Column name:" + rsMetaData.getColumnName(column));
					System.out.println("Column type name:" + rsMetaData.getColumnTypeName(column));
					System.out.println("Is Nullable:" + rsMetaData.isNullable(column));
					System.out.println("Is Auto Increment:" + rsMetaData.isAutoIncrement(column));
				}
		}

				 catch (Exception exc) {
					exc.printStackTrace();
		} finally {
				Object myRs;
				close(myConn,myStmt,myRs);
		}
}

}

private static void () {
	// TODO Auto-generated method stub
	
}		
}

