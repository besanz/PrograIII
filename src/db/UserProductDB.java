package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Order;
import data.Product;
import data.User;

public class UserProductDB {
	
	
	public static void insertUserProduct(int IdUserU, int IdProductP) {
		String sql = "INSERT INTO UserProduct(IdUserU,IdProductP) VALUES (?,?)";

		try {
			Connection conn = DBConnector.connect();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, IdUserU);
			pstmt.setInt(2, IdProductP);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
    /**
     * @author JON ANDER ARANA
     * Receiving users from database
     */

    public static ArrayList<Product> selectProductUser(User u)
    {
        String sql = "SELECT IdUserU,IdProductP FROM UserProduct";
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<Product> prod = db.ProductDB.selectProduct();

        try
                (
                        Connection conn = DBConnector.connect();
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

