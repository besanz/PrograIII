package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class DeleteDb
{
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
	   private static Connection connect() {
	        // SQLite connection string

	        String name = "BaseDeDatos.db";
	        String url = "jdbc:sqlite:" + name;

	        Connection conn = null;

	        try {
	            conn = DriverManager.getConnection(url);
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }

    /**
     * Delete a user specified by the id
     *
     * @param id
     */
    public static void delete(String n)
    {
        String sql = "DELETE FROM User WHERE Name = ?";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            
            pstmt.setString(1, n);

            
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteP(String p)
    {
        String sql = "DELETE FROM Product WHERE Name = ?";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            
            pstmt.setString(1, p);

            
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
   
    }
