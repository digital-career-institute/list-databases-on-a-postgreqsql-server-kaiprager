package databases_on_postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreqSqlConnector {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/test";
	private static final String USERNAME = "xxx";
	private static final String PASSWORD = "xxx";
	
	public static Connection connect() throws SQLException {
		
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

}
