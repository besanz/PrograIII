package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Client;
import data.User;

public class UserDB {

	/**
	 * @auhor Benat
	 * @return
	 */
	public static void addUser(String username, String password, boolean isAdmin, int saldo) {
		String sql = "INSERT INTO User( Name, password, isAdmin, saldo) VALUES(?,?,?,?)";
		try (Connection conn = DBConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setBoolean(3, isAdmin);
			pstmt.setInt(4, saldo);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Delete a user specified by the id
	 *
	 * @param id
	 */
	public static void delete(String n) {
		String sql = "DELETE FROM User WHERE Name = ?";

		try (Connection conn = DBConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, n);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateSaldo(int id, int valor) {

		String sql = "UPDATE User SET saldo =  ? WHERE id = ? ";
		// int a = (int) Math.round(valor);
		try {
			Connection conn = DBConnector.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, id);
			pstmt.setInt(1, valor);
			pstmt.executeUpdate();
			System.out.println("hola");
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	public static void insertUser(int idUser, String username, String password, boolean isAdmin) {
		String sql = "INSERT INTO User(id, Name, password,IsAdmin) VALUES(?,?,?,?)";

		try (Connection conn = DBConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idUser);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setBoolean(4, isAdmin);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @author Benat Receiving users from database
	 */

	public static ArrayList<User> selectUser() {
		String sql = "SELECT id, Name, password,IsAdmin,saldo FROM User";
		ArrayList<User> users = new ArrayList<User>();

		try (Connection conn = DBConnector.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {

			while (rs.next()) {
				boolean esAdmin = false;
				if (rs.getInt("IsAdmin") == 1) {
					esAdmin = true;
					users.add(new User(rs.getInt("id"), rs.getString("Name"), rs.getString("password"),
							rs.getInt("saldo"), esAdmin));
				} else {
					users.add((User) new Client(rs.getInt("id"), rs.getString("Name"), rs.getString("password"),
							rs.getInt("saldo"), esAdmin));
				}

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return users;

	}

	public static void main(String[] args) {
		ArrayList<User> u = UserDB.selectUser();
		System.out.println(u);
	}

}
