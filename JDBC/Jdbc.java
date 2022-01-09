package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class Jdbc {

	public static void main(String[] args) throws SQLException {
		java.sql.Statement stmt = null;
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBC";
		Connection conn = DriverManager.getConnection(connectionUrl, "MYNGUYEN", "1234567");

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id ,name,quatity,price from products ");
	
		
		//while(rs.next()) {
		 //System.out.println((rs.getString(1)+ " "+ rs.getString(2)+ " "+ rs.getString(3)+ " "+rs.getString(4)) 
		//		);
		 
	//	}
		
		
		
		while(rs.next()) {
		if(rs.getString(1).equals("1") & rs.getString(2).equals("coca") & rs.getString(3).equals("100") & rs.getString(4).equals("10")) {
				System.out.println("true");
				
			}
		else {
			System.out.println("false");
		}
			
		}
//		
		
			

		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		} finally {
		try {
		stmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
	}
}
