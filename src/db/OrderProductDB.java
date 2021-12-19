package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Product;

public class OrderProductDB {
	
	
	/**
	 * @author JON ANDER ARANA;
	 * @author Benat
	 */
	/**
	 * Insert a new row into the Basket table
	 *
	 * @param idProduct
	 * @param idOrder
	 * @param quantityProduct
	 * @param date
	 * @param
	 */
	public static void insertOrderProduct(int idProduct, int idO, int quantityProduct, int orderDate) {
		String sql = "INSERT INTO ORDERPRODUCT(idProduct,idO,quantityOrder,orderDate)VALUES(?,?,?,?)";

		try (Connection conn = DBConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idProduct);
			pstmt.setInt(2, idO);
			pstmt.setInt(3, quantityProduct);
			pstmt.setInt(4, orderDate);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}


    /**
     * @author JON ANDER ARANA
     * Receiving users from database
     */

    public static ArrayList<Product> selectProduct()
    {
        String sql = "INSERT INTO Product id,name,Price,stock ";
        ArrayList<Product> products = new ArrayList<Product>();

        try
                (
                        Connection conn = DBConnector.connect();
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
