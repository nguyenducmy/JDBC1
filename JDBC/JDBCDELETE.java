package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDELETE {


	public static void main(String[] args) throws SQLException {
		PreparedStatement preparedStatement = null;
		

		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBC";
		Connection conn = DriverManager.getConnection(connectionUrl, "MYNGUYEN", "1234567");

		String query = "DELETE FROM dbo.products where id='7'";
		preparedStatement = conn.prepareStatement(query);
		
		preparedStatement.executeUpdate();
		System.out.println("DELETE FINISHED");
		
		
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
