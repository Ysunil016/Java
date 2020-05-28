package Postgres.Connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresConnect {

	Connection connection = null;

	public Connection getConnection(String dbName) throws ClassNotFoundException, SQLException {
		dbName = dbName.toLowerCase();
		if (connection != null) {
			System.out.println("Database Connected..");
			return connection;
		} else
			return makeAndGetConnection(dbName);
	}

	private Connection makeAndGetConnection(String dbName) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, "postgres",
					"root123");
			return connection;
		} catch (SQLException e) {
			System.out.println(e);
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "root123");
			Statement stm = connection.createStatement();
			stm.execute("CREATE DATABASE " + dbName);
			stm.close();

			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, "postgres",
					"root123");
			return connection;
		}
	}

}
