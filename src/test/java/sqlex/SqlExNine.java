package sqlex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.testng.annotations.Test;

public class SqlExNine extends SuperDatabase { 
	
	@Test
	public void updateStoreTimeStamp() throws SQLException {
		try {
			connection = getDatabaseConnection();
			
			String latestStoreSQL = "SELECT Max(store_id) FROM sakila.store";
			Statement stmt = connection.createStatement();
			
			
			
			ResultSet resultSet = stmt.executeQuery(latestStoreSQL);
			int latestStoreId = resultSet.next() == true ? resultSet.getInt(1) : 0;
			
			String updateStaffSql = "UPDATE sakila.store "
					+ "SET last_update = ?"
			    	+ "WHERE store_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(updateStaffSql);

			ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			ps.setInt(2, latestStoreId);
			
			ps.executeUpdate();
						
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