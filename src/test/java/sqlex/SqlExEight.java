package sqlex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class SqlExEight extends SuperDatabase { 
	
	
	@Test
	public void startTransaction() throws SQLException {
		try {
			connection = getDatabaseConnection();
			connection.setAutoCommit(false);
	
			String insertStaffSql = "INSERT INTO sakila.staff (first_name, last_name, address_id, store_id, username) "
					+ "VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(insertStaffSql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, "Wai");
			ps.setString(2, "Chan");
			ps.setInt(3, 5);
			ps.setInt(4, 2);
			ps.setString(5, "quintrix-trainee");
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			int latestStaffId = 0;
			
			if (rs.next()) {
				latestStaffId = rs.getInt(1);
				System.out.println(latestStaffId);
			}
			
			String insertStoreSql = "INSERT INTO sakila.store (manager_staff_id, address_id) Values(?, ?)";
			PreparedStatement ps2 = connection.prepareStatement(insertStoreSql, Statement.RETURN_GENERATED_KEYS);
			ps2.setInt(1, latestStaffId);
			ps2.setInt(2, 5);
			
			ps2.executeUpdate();
			
			ResultSet rs2 = ps2.getGeneratedKeys();
			
			int latestStoreId = 0;
			if (rs2.next()) {
				latestStoreId = rs2.getInt(1);
						System.out.println(latestStoreId);}
			
			String updateStaffSql = "UPDATE sakila.staff " + 
					"SET store_id = ? " + 
					"WHERE staff_id = ?";

			PreparedStatement ps3 = connection.prepareStatement(updateStaffSql);
			ps3.setInt(1, latestStoreId);
			ps3.setInt(2, latestStaffId);
			System.out.println(latestStoreId +" " + latestStaffId);
			ps3.executeUpdate();
			connection.commit();
			
		}
		catch (Exception e) {
			connection.rollback();
			throw new RuntimeException(e);
		} 
		finally {
			if(connection != null ) {
				connection.close();
			}
		}

	}
	
}