package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Product;

public class SelectProduct {
	
	 private static Connection connect()
	    {
	        // SQLite connection string
	        String name = "BaseDeDatos.db";
	        String url = "jdbc:sqlite:" + name;
	        Connection conn = null;

	        try
	        {
	            conn = DriverManager.getConnection(url);
	        }
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        return conn;
	    }

	    /**
	     * @author JON ANDER ARANA
	     * Receiving users from database
		 * @param sql
	     */

	    public static ArrayList<Product> selectProduct()
	    {
	        String sql = "Select id,name,Price,stock from Product ";
	        ArrayList<Product> products = new ArrayList<Product>();

	        try
	                (
	                        Connection conn = connect();
	                        Statement stmt  = conn.createStatement();
	                )
	        {
	        	ResultSet rs    = stmt.executeQuery(sql);

	            while (rs.next())
	            {
	                       Product p = new Product( rs.getInt("id"),rs.getString("Name"),rs.getInt("Price"),rs.getInt("Stock"));
	                        products.add(p);
	                       
	            }
	        } catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        }
	        return products;
	    }
	   

}

