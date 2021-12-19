package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class DeleteDB
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
     * @param args the command line arguments
     */
   
    }
