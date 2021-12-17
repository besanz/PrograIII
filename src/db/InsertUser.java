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
	 
	 public static void addUser( String username, String password, boolean isAdmin, int saldo){
		 String sql = "INSERT INTO User( Name, password, isAdmin, saldo) VALUES(?,?,?,?)";
	        try
         (
         		Connection conn = connect();
                 PreparedStatement pstmt  = conn.prepareStatement(sql)
         )
 {
	          
	            pstmt.setString(1, username);
	            pstmt.setString(2, password);
	            pstmt.setBoolean(3, isAdmin);
	            pstmt.setInt(4, saldo);

	            
	            pstmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	    }
	 }
