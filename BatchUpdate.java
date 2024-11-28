package jdbcjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdate {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static String url = "jdbc:mysql://localhost:3306/company2024";
	static String username = "root";
	static String password = "Anandsri@1008";
	static String query = "Insert into employee(empid, empname, dept, salary, email)"
			+ " values(?, ?, ?, ?, ?)";
	static int empid =0, salary =0;
	static String empname = null, dept = null, email =null;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String option = "yes";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
			while(option.equals("yes")) {
				System.out.println("Enter Employee Id: ");
				empid = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Employee Name: ");
				empname = scan.nextLine();
				System.out.println("Enter Employee Department: ");
				dept = scan.next();
				System.out.println("Enter Employee Salary: ");
				salary = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter Employee Email: ");
				email = scan.nextLine();
				System.out.println("Do you want to continue(yes / no): ");
				option = scan.next().toLowerCase();
				
				
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, empid);
				pstmt.setString(2, empname);
				pstmt.setString(3, dept);
				pstmt.setInt(4, salary);
				pstmt.setString(5, email);
				
				pstmt.addBatch();
			}
			int sum=0;
			
			long[] a = pstmt.executeLargeBatch();
			System.out.println("Size of a is : " + a.length);
			for(long x : a) {
				sum += x;
			}
			
			if(sum>0) {
				System.out.println(sum + " rows inserted Successfully...");
			}
			else {
				System.out.println("No rows inserted..");
			}
			
		}
		
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				scan.close();
				if(con != null) {
					con.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
