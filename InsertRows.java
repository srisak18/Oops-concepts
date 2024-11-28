package jdbcjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertRows {
	public static void main(String[] args) {
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		int id, salary;
		String name, dept, email;
		
		System.out.println("Enter employee id: ");
		id = sc1.nextInt();
		System.out.println("Enter employee name: ");
		name = sc2.nextLine();
		System.out.println("Enter department: ");
		dept = sc2.nextLine();
		System.out.println("Enter salary: ");
		salary = sc1.nextInt();
		System.out.println("Enter email: ");
		email = sc2.nextLine();
		
		sc1.close();
		sc2.close();
		
		String q = "insert into `employee` (`empid`, `empname`, `dept`, `salary`, `email`)" 
				+ "values (?, ?, ?, ?, ?)";
		
		try {
			
			con = MyConnect.connect();
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(4, salary);
			pstmt.setString(3, dept);
			pstmt.setString(5, email);
			
			int x = pstmt.executeUpdate();
			System.out.println("Output is "+x);
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
