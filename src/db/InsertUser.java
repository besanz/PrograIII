package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUser {

	/** 
	 * 
	 * @author Benat
	 * @return conn, the connection that was established to DriverManager
	 */
	 private static Connection connect()
	    {
	        String url = "jdbc:sqlite:BaseDeDatos.db";
	        Connection conn = null;
	        try
	        {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }
	 
	 public static void addUser(int idUser, String username, String password, boolean isAdmin){
		 String sql = "INSERT INTO user(id, Name, password,IsAdmin) VALUES(?,?,?,?)";
	        try
         (
         		Connection conn = connect();
                 PreparedStatement pstmt  = conn.prepareStatement(sql)
         )
 {
	            pstmt.setInt(1, idUser);
	            pstmt.setString(2, username);
	            pstmt.setString(3, password);
	            
	            //Check later. Administrator. + security?
	            pstmt.setBoolean(4, isAdmin);
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	 }
