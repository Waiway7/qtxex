package sqlex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SqlExTen extends SuperDatabase { 
	
	@Test
	public void deleteNewStore() throws SQLException {
		try {
			
			connection = getDatabaseConnection();
			connection.setAutoCommit(false);
			String latestStoreSQL = "SELECT Max(store_id) FROM sakila.store";
			Statement stmt = connection.createStatement();
			
			ResultSet resultSet = stmt.executeQuery(latestStoreSQL);
			int latestStoreId = resultSet.next() == true ? resultSet.getInt(1) : 0;
			
			String latestStaffSQL = "SELECT Max(staff_id) FROM sakila.staff";
			Statement stmt2 = connection.createStatement();
			
			ResultSet resultSet2 = stmt2.executeQuery(latestStaffSQL);
			int latestStaffId = resultSet2.next() == true ? resultSet2.getInt(1) : 0;
			
			String updateStaffSql = "UPDATE sakila.staff" + 
										" SET store_id = 2" + 
										" WHERE staff_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(updateStaffSql);
			ps.setInt(1, latestStaffId);
			ps.executeUpdate();

			String deleteNewStoreSql = "DELETE FROM sakila.store where store_id = ?";
			String deleteNewStaffSql = "DELETE FROM sakila.staff where staff_id = ?";
			
			PreparedStatement ps2 = connection.prepareStatement(deleteNewStoreSql);
			ps2.setInt(1, latestStoreId);
			ps2.executeUpdate();
			
			PreparedStatement ps3 = connection.prepareStatement(deleteNewStaffSql);
			ps3.setInt(1, latestStaffId);
			ps3.executeUpdate();
			connection.commit();
					
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