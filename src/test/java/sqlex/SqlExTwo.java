package sqlex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SqlExTwo extends SuperDatabase { 
		
	@Test
	public void fetchingFilmsWithAirplaneTitle() throws SQLException {
		String sql = "SELECT title "
					+ "FROM sakila.film "
					+ "WHERE title LIKE '%airplane%';";
		try {
			connection = getDatabaseConnection();
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
			
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		} 
		finally {
			if(connection != null ) {
				connection.close();
			}
		}
		
	}
	
}