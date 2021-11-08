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
     */
    public void insertProduct(int id,String name,int price)
    {
        String sql = "INSERT INTO Product(id,name,price) VALUES(?,?,?)";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setInt(3,price);
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
        app.insertProduct(51,"Envoy", 3000);

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
     * @param quantity
     * @param idUser
     * @param idProduct
     */
    public void insertBasket(int id ,int quantity , int idUser,int idProduct)
    {
    	String sql = "INSERT INTO BASKET(id,quantity,idUser,idProduct)VALUES(?,?,?,?)";
    	
        try
        (
                Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        )
{
    pstmt.setInt(1,id);
    pstmt.setInt(2,quantity);
    pstmt.setInt(3,idUser);
    pstmt.setInt(4,idProduct);
    pstmt.executeUpdate();
}
catch (SQLException e)
{
    System.out.println(e.getMessage());}

    	
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
        	String sql = "INSERT INTO OrderRecord(id,totalpaid,idUser)VALUES(?,?,?)";
        	
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
         * @param id
         * @param Quantity Order
         * @param idOrder
         * @param idUser
         * @param PricePerProduct
         */
        public void insertOrderDetail(int id ,int quantityOrder , int idOrder,int idUser, int PricePerProduct)
        {
        	String sql = "INSERT INTO OrderDetail(id,quantityOrder,idOrder,idUser,PricePerProduct)VALUES(?,?,?,?,?)";
        	
        	 try
             (
                     Connection conn = this.connect();
                     PreparedStatement pstmt = conn.prepareStatement(sql)
             )
     {
         pstmt.setInt(1,id);
         pstmt.setInt(2,quantityOrder);
         pstmt.setInt(3,idOrder);
         pstmt.setInt(4,idUser);
         pstmt.setInt(5,PricePerProduct);
         pstmt.executeUpdate();
     }
     catch (SQLException e)
     {
         System.out.println(e.getMessage());

         	
         }
             
        	
        }
        
       
}
    
	

