package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Order;

public class OrderRecordDB {
	
	/*
	 * @author JON ANDER ARANA;
	 */
	/**
	 * Insert a new row into the Basket table
	 *
	 * @param id
	 * @param totalpaid
	 * @param idUser
	 */
	public void insertOrderRecord(int idOrder, int totalpaid, int idUser) {
		String sql = "INSERT INTO OrderRecord(idOrder,totalpaid,idUser)VALUES(?,?,?)";

		try (Connection conn = DBConnector.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, idOrder);
			pstmt.setInt(2, totalpaid);
			pstmt.setInt(3, idUser);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}

	}


    /**
     * @author JON ANDER ARANA
     * Receiving users from database
     */

    public static ArrayList<Order> selectOrderRecord()
    {
        String sql = "INSERT INTO idOrder,totalpaid,idUser";
        ArrayList<Order> orderRecord = new ArrayList<Order>();

        try
                (
                        Connection conn = DBConnector.connect();
                        Statement stmt  = conn.createStatement();
                )
        {
        	ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next())
            {
                       Order o = new Order(rs.getInt("idOrder"),rs.getInt("totalpaid"),rs.getInt("idUser"));
                        orderRecord.add(o);
                       
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return orderRecord;
    }
   


}
