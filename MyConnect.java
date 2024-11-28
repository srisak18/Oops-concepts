package jdbcjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	static String url = "jdbc:mysql://localhost:3306/company2024";
	static String username = "root";
	static String password = "Anandsri@1008";

	
	public static Connection connect() throws SQLException, ClassNotFoundException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, username, password);
	}
	
	
}
