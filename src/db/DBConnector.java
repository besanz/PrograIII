package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author sqlitetutorial.net
 * @author JON ANDER ARANA
 */
public class DBConnector
{

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect()
    {
        // SQLite connection string
        String name = "BaseDeDatos.db";
        String url = "jdbc:sqlite:"+name;

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

    /**
     * Insert a new row into the Product table
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     */
    public void insertProduct(int id,String name,int price,int stock)
    {
        String sql = "INSERT INTO Product(id,name,price,stock) VALUES(?,?,?,?)";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setInt(3,price);
            pstmt.setInt(4,stock);
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
    public static void main(String[] args)
    {

        DBConnector app = new DBConnector();

        // insert three new rows
        app.insertProduct(51,"Envoy", 3000,9345);

    }
    
    /**
     * Insert a new row into the warehouses table
     *
     * @param id
     * @param name
     * @param password
     * @parama isAdmin
     */
    public void insertUser(int id,String name,String password,boolean isAdmin )
    {
        String sql = "INSERT INTO User(id,name,password,isAdmin) VALUES(?,?,?,?)";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,password);
            int myInt = isAdmin ? 1:0;
            pstmt.setInt(4,myInt);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
   
        /**
         * @author JON ANDER ARANA;
         */
        /**
         * Insert a new row into the Basket table
         *
         * @param id
         * @param totalpaid
         * @param idUser
         */
        public void insertOrderRecord(int id ,int totalpaid , int idUser)
        {
        	String sql = "INSERT INTO Order(id,totalpaid,idUser)VALUES(?,?,?)";
        	
            try
            (
                    Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)
            )
    {
        pstmt.setInt(1,id);
        pstmt.setInt(2,totalpaid);
        pstmt.setInt(3,idUser);
        pstmt.executeUpdate();
    }
    catch (SQLException e)
    {
        System.out.println(e.getMessage());

        	
        }
            
}

        /**
         * @author JON ANDER ARANA;
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
        public void insertOrderProduct(int idProduct ,int idO , int quantityProduct,int orderDate)
        {
        	String sql = "INSERT INTO ORDERPRODUCT(idProduct,idO,quantityOrder,orderDate)VALUES(?,?,?,?)";
        	
        	 try
             (
                     Connection conn = this.connect();
                     PreparedStatement pstmt = conn.prepareStatement(sql)
             )
     {
         pstmt.setInt(1,idProduct);
         pstmt.setInt(2,idO);
         pstmt.setInt(3,quantityProduct);
         pstmt.setInt(4,orderDate);
         pstmt.executeUpdate();
     }
     catch (SQLException e)
     {
         System.out.println(e.getMessage());

         	
         }
             
        	
        }
        
       
}
    
	
