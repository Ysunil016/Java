package Postgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresOperations {

	public boolean createTable(Connection conn, String TableName) {
		String query = "CREATE TABLE " + TableName + "(name varchar(50));";
		System.out.println(query);
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(query);
			stm.close();
		} catch (SQLException e) {
			System.out.println("EXCEPTION");
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	

}
