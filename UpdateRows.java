package jdbcjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateRows {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String q;
		System.out.println("1. Increment \n2. Decrement \nEnter your choice: ");
		int choice = sc.nextInt();
		System.out.println("Enter the employee id: ");
		int id = sc.nextInt();
		System.out.println("Enter the amount to be Incremented / Decremented: ");
		int value = sc.nextInt();
		sc.close();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		if(choice == 1) {
			q = "update `employee` set `salary` = `salary` + ? where `empid` = ?";
		}
		else {
			q = "update `employee` set `salary` = `salary` - ? where `empid` = ?";	
		}
		
		
		try {
			
			con = MyConnect.connect();
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, value);
			pstmt.setInt(2, id);
			int x = pstmt.executeUpdate();
			System.out.println("Output is " + x);
			
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
