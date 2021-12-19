package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Product;
import data.User;

public class ProductDB {
	public static void updateStock(int id, int stock) {

		String sql = "UPDATE Product SET stock = ? WHERE id = ? ";

		try {
			Connection conn = DBConnector.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, id);
			pstmt.setInt(1, stock);
			pstmt.executeUpdate();
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	public static void deleteProduct(String p) {
		String sql = "DELETE FROM Product WHERE Name = ?";

		try (Connection conn = DBConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, p);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Insert a new row into the Product table
	 *
	 * @param id
	 * @param name
	 * @param price
	 * @param stock
	 */
	public static void insertProduct(String name, int price, int stock) {
		String sql = "INSERT INTO Product(name,price,stock) VALUES(?,?,?)";

		try (Connection conn = DBConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setInt(3, stock);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @param idUser
	 * @param username
	 * @param password
	 * @param isAdmin
	 * @author Benat Inserting user to the database
	 */

	/**
	 * @author JON ANDER ARANA Receiving users from database
	 * @param sql
	 */

	public static ArrayList<Product> selectProduct() {
		String sql = "Select id,name,Price,stock from Product ";
		ArrayList<Product> products = new ArrayList<Product>();

		try {
			Connection conn = DBConnector.connect(); 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Product p = new Product(rs.getInt("id"), rs.getString("Name"), rs.getInt("Price"), rs.getInt("Stock"));
				products.add(p);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return products;
	}
}
