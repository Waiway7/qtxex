package sqlex;

import java.sql.Connection;
import java.sql.DriverManager;

public class SuperDatabase {
	private String url = "jdbc:mysql://127.0.0.1:3306/sakila?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String userId = "root";
	private String password = "";
	protected Connection connection = null;
	
	protected Connection getDatabaseConnection() throws Exception {
		connection = DriverManager.getConnection(url, userId, password);

		if (connection == null) {
			throw new Exception("Failed to make connection!");
		}	

		return connection;
	}
}