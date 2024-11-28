package jdbcjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRow {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id to delete the record: ");
		int id = sc.nextInt();
		sc.close();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String q= "delete from `employee` where `empid` = ?";
		
		try {
			
			con = MyConnect.connect();
			pstmt = con.prepareStatement(q);
			pstmt.setInt(1, id);
			int x = pstmt.executeUpdate();
			System.out.println("Output is : "+x);
			
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
