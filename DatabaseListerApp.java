package databases_on_postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseListerApp {

	public static void main(String[] args) {
		
		try(Connection connection = PostgreqSqlConnector.connect()) {
			listDatabases(connection);
		} catch (SQLException e) {
			System.out.println(e);
		
		}

	}
	
	private static void listDatabases(Connection connection) throws SQLException {
		
		String query = "SELECT datname FROM pg_database";
		
		try(PreparedStatement ps = connection.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			
			System.out.println("List of Databases: ");
			while(rs.next()) {
				String databaseName = rs.getString("datname");
				System.out.println(databaseName);
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}  finally {
			
			if(connection != null) {
				connection.close();
			}
		}
		
	}

}
