package jdbcjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectAsPerUserWish {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the id of an Employee: ");
		int id = scan.nextInt();
		int salary;
		String name, dept, email;
		scan.close();
		Connection con = null;
		PreparedStatement pstmt = null;
		String q = "select * from `employee` where empid = ?";
		
		try {
			con = MyConnect.connect();
			pstmt= con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			System.out.println("The respective data is: ");
			
			while(res.next() == true) {
				id = res.getInt(1);
				name = res.getString(2);
				dept = res.getString(3);
				salary = res.getInt(4);
				email = res.getString(5);
				System.out.printf("%d %-15s %-10s %-6d %s \n", id,name,dept,salary,email);
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
