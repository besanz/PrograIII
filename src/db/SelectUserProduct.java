package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Order;
import data.Product;
import data.User;

public class SelectUserProduct {
	
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
     */

    public static ArrayList<Product> selectProductUser(User u)
    {
        String sql = "SELECT IdUserU,IdProductP FROM UserProduct";
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Product> prod = db.SelectProduct.selectProduct();

        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
                )
        {
        	ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next())
            {
            	if(u.getIdUser()==rs.getInt("IdUserU")){
            		for(Product a : prod){
            			if(a.getIdProduct()==rs.getInt("IdProductP")){
            				products.add(a);
            			}
            		}
            	}
                       
                       
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return products;
    }
   


}

