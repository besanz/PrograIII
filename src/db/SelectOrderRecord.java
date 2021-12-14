package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Order;

public class SelectOrderRecord {
	
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

    public static ArrayList<Order> selectOrderRecord()
    {
        String sql = "INSERT INTO idOrder,totalpaid,idUser";
        ArrayList<Order> orderRecord = new ArrayList<Order>();

        try
                (
                        Connection conn = connect();
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
