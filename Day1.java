package jdbcjava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Day1 {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		int id, salary;
		String dept, name, email;
		
		try {
			
			System.out.println("Driver Loaded..");
			
			con = MyConnect.connect();
			System.out.println("Connection Established : " + con+"\n");
			
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery("Select * from employee");
			
			while(res.next() == true) {
				id = res.getInt(1);
				name = res.getString(2);
				dept = res.getString(3);
				salary = res.getInt(4);
				email = res.getString(5);
				System.out.printf("%d %-20s %-10s %-10d %s \n", id,name,dept,salary,email);
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) {
					con.close();
				}
				if(stmt != null) {
					stmt.close();
					
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
}
