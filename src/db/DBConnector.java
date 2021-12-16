package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnector {

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
     * Insert a new row into the Product table
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     */
    public static void insertProduct( String name, int price, int stock) {
        String sql = "INSERT INTO Product(name,price,stock) VALUES(?,?,?)";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                ) {
            
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, stock);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param idUser
     * @param username
     * @param password
     * @param isAdmin
     * @author Benat
     * Inserting user to the database
     */

    public static void insertUser(int idUser, String username, String password, boolean isAdmin) {
        String sql = "INSERT INTO User(id, Name, password,IsAdmin) VALUES(?,?,?,?)";

        try
                (
                        Connection conn = connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                ) {
            pstmt.setInt(1, idUser);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setBoolean(4, isAdmin);
            pstmt.executeUpdate();
        } catch (SQLException e) {
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
        public void insertOrderRecord(int idOrder ,int totalpaid , int idUser)
        {
        	String sql = "INSERT INTO OrderRecord(idOrder,totalpaid,idUser)VALUES(?,?,?)";
        	
            try
            (
                    Connection conn = this.connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)
            )
    {
        pstmt.setInt(1,idOrder);
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
        public static void insertUserProduct (int IdUserU ,int IdProductP)
        {
        	String sql = "INSERT INTO UserProduct(IdUserU,IdProductP)VALUES(?,?)";
        	
       	 try
            (
                    Connection conn = connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql)
            )
        {
        pstmt.setInt(1,IdUserU);
        pstmt.setInt(2,IdProductP);
        pstmt.executeUpdate();
        }
        catch (SQLException e){
       
        System.out.println(e.getMessage());

        	
             }
        	
        }
}
    
	
