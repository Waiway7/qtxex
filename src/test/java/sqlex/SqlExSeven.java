package sqlex;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SqlExSeven extends SuperDatabase { 
	
	
	@Test
	public void fetchingAlienMoviesInInv() throws SQLException {
		String sql = "CREATE PROCEDURE `GetInventoryIds`(IN movie_title varchar(24)) " 
						+ "BEGIN"
						+ " SELECT i.inventory_id"
						+ " FROM sakila.inventory i"
						+ " JOIN sakila.store s"
							+ " ON s.store_id = i.store_id"
						+ " JOIN sakila.film f"
						+	" ON i.film_id = f.film_id"
						+ " WHERE f.title = movie_title;"
						+ " END;";
		String procedure = "{CALL GetInventoryIds(?)}";

			try {
				connection = getDatabaseConnection();

				Statement statement = connection.createStatement();

				statement.execute(sql);
				CallableStatement stmt = connection.prepareCall(procedure);
				stmt.setString("movie_title", "Alien Center");
				ResultSet resultSet = stmt.executeQuery();
				while (resultSet.next()) {
					System.out.println(resultSet.getString(1));
				}
			}
			catch (Exception e) {
				if (e.getMessage().contains("PROCEDURE GetInventoryIds already exists")) {
					try {
						CallableStatement stmt = connection.prepareCall(procedure);
						stmt.setString("movie_title", "Alien Center");
						ResultSet resultSet = stmt.executeQuery();
						while (resultSet.next()) {
							System.out.println(resultSet.getString(1));
						}
					}
					catch (Exception err) {
						throw new RuntimeException(err);
					}
				}
				else {
					throw new RuntimeException(e);
				}
			} 
			finally {
				if(connection != null ) {
					connection.close();
				}
			}
	}
	
}