package jdbcjava;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Details{
	static int id = 0;
	static String name = null;
	static String dept = null;
	static int salary = 0;
	static String email = null;
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static String q = "";
	
	
}

class InsertRecord extends Details{
	
	public static void insertion() throws SQLException, ClassNotFoundException{
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		q = "insert into `employee` (`empid`, `empname`, `dept`, `salary`, `email`)" + 
				"values (?, ?, ?, ?, ?)";
		
		System.out.println("Enter employee id: ");
		id = sc1.nextInt();
		System.out.println("Enter employee name: ");
		name = sc2.nextLine();
		System.out.println("Enter employee department: ");
		dept = sc2.nextLine();
		System.out.println("Enter employee salary: ");
		salary = sc1.nextInt();
		System.out.println("Enter employee email: ");
		email = sc2.nextLine();
		
		int res = 0;
		
		
		try {
			
			con = MyConnect.connect();
			pstmt  =con.prepareStatement(q);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);
			pstmt.setInt(4, salary);
			pstmt.setString(5, email);
			res = pstmt.executeUpdate();
			
		}
		finally {
			if(res > 0) {
				System.out.println("Record Inserted..");
			}
			else {
				System.out.println("Not Inserted... ");
			}
		}
	}
}


class UpdateRecord extends Details{
	
	public static void updation() throws SQLException, ClassNotFoundException{
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Select option \n1) Increment Salary \n2) Decrement Salary \nEnter your option: ");
		int option = sc1.nextInt();
		System.out.println("Enter employee id: ");
		id = sc1.nextInt();
		System.out.println("Enter amount to be incremented/decremented: ");
		int value = sc1.nextInt();
		if(option == 1) {
			q = "update `employee` set `salary` = `salary` + ? where `empid` = ?";
		}
		else if(option == 2){
			q = "update `employee` set `salary` = `salary` - ? where `empid` = ?";
		}
		else {
			System.out.println("Invalid option...");
		}
		int res = 0;
		
		
		try {
			
			con = MyConnect.connect();
			pstmt  =con.prepareStatement(q);
			pstmt.setInt(1, value);
			pstmt.setInt(2, id);
			res = pstmt.executeUpdate();
			
		}
		finally {
			if(res > 0) {
				System.out.println("Record Updated..");
			}
			else {
				System.out.println("Not Updated... ");
			}
		}
	}
}


class DeletingRecord extends Details{
	
	public static void deletion() throws SQLException, ClassNotFoundException{
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter employee id of the record to delete: ");
		id = sc1.nextInt();
		q = "delete from `employee` where `empid` = ?";
		int res = 0;
		
		try {
			
			con = MyConnect.connect();
			pstmt  =con.prepareStatement(q);
			pstmt.setInt(1, id);
			res = pstmt.executeUpdate();
			
		}
		finally {
			if(res > 0) {
				System.out.println("Record Deleted..");
			}
			else {
				System.out.println("No such Record... ");
			}
		}
	}
}

class Display extends Details{
	
	public static void displayRecord() throws SQLException, ClassNotFoundException{
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter employee id to fetch the record: ");
		id = sc1.nextInt();
		q = "select * from `employee` where `empid` = ?";
		ResultSet res = null;
		
		try {
			
			con = MyConnect.connect();
			pstmt  =con.prepareStatement(q);
			pstmt.setInt(1, id);
			res = pstmt.executeQuery();
			display(res);
			
		}
		finally {
			if(res == null) {
				System.out.println("No such record exist..");
			}
			
		}
	}
	
	
	public static void displayTable() throws SQLException, ClassNotFoundException{
		
		q = "select * from `employee`";
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			
			con = MyConnect.connect();
			stmt = con.createStatement();
			res = stmt.executeQuery(q);
			display(res);
			
		}
		finally {
			if(res == null) {
				System.out.println("No such table exist..");
			}
			if(stmt != null) {
				stmt.close();
			}
		}
	}
	
	public static void display(ResultSet res) throws SQLException {
		while(res.next() == true) {
			id = res.getInt(1);
			name = res.getString(2);
			dept = res.getString(3);
			salary = res.getInt(4);
			email = res.getString(5);
			System.out.printf("%-3d  %-20s %-10s %-6d %s\n", id, name, dept, salary, email);
		}
	}
}


public class DatabaseOperations extends Details {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String cont = "yes"; 
		
		try {
			while(cont.equals("yes")) {
				System.out.println("Operations are: \n1.Inserting Record \n2.Updating Record \n3.Deleting Record \n4.Displaying Particular Record \n5.Displaying Whole Table");
				System.out.println("Enter your choice: ");
				int choice = scan.nextInt(); 
				
				switch(choice) {
				
				case 1:
					
					InsertRecord.insertion();
					break;
					
				case 2:
					
					UpdateRecord.updation();
					break;
					
				case 3:
					
					DeletingRecord.deletion();
					break;
					
				case 4:
					
					Display.displayRecord();
					break;
					
				case 5:
					
					Display.displayTable();
					break;
					
				default:
					
					System.out.println("Enter Valid option...");
					break;
				}
				System.out.println("Do you want to continue (yes/no): ");
				cont = scan.next().toLowerCase();
			}
		}
		catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Thank you! Connection Terminated..");
			scan.close();
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		
	}
}
