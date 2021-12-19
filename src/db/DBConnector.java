package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnector {

	/**
	 * Connect to the test.db database
	 *
	 * @return the Connection object
	 */
	private static Connection conn=null;
	

	public static Connection connect() {
		// SQLite connection string
		if (conn == null) {
			String name = "BaseDeDatos.db";
			String url = "jdbc:sqlite:" + name;

			try {
				conn = DriverManager.getConnection(url);
			} catch (SQLException e) {
				System.out.println("Error de conexion "+e.getMessage());
				return null;
			}
		}
		else{
			try {
				conn.close();
				String name = "BaseDeDatos.db";
				String url = "jdbc:sqlite:" + name;
				conn = DriverManager.getConnection(url);
			} catch (SQLException e) {
				System.out.println("Error de conexion "+e.getMessage());
				return null;
			}
		}
		return conn;
	}
}
