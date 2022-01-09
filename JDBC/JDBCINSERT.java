package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCINSERT {

	public static void main(String[] args) throws SQLException {
		PreparedStatement preparedStatement = null;
		

		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBC";
		Connection conn = DriverManager.getConnection(connectionUrl, "MYNGUYEN", "1234567");

		String query = "INSERT INTO dbo.products VALUES (?,?,?,?)";
		preparedStatement = conn.prepareStatement(query);
		preparedStatement.setString(1,"6");
		preparedStatement.setString(2,"heineken");
		preparedStatement.setString(3,"1000");
		preparedStatement.setString(4,"30");
		preparedStatement.executeUpdate();
		System.out.println("INSERT FINISHED");
		
		
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		} finally {
		try {
		preparedStatement.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
	}
}
