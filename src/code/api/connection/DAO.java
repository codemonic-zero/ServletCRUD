package code.api.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

	private static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDB", "root", "root");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
