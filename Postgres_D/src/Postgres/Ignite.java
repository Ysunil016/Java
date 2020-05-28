package Postgres;

import java.sql.Connection;
import java.sql.SQLException;

import Postgres.Connectors.PostgresConnect;

public class Ignite {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Connection pConnect = new PostgresConnect().getConnection("sunil");
		PostgresOperations postOperations = new PostgresOperations();

		postOperations.createTable(pConnect, "sanjay");
	}

}
