package db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JON ANDER ARANA
 */
public class SelectTable
{
    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect()
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
     * select all rows in the product table
     */
    public void selectAll()
    {
        String sql = "SELECT id, Name, Price,Stocks FROM Product";

        try
                (
                        Connection conn = this.connect();
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
            while (rs.next())
            {
                System.out.println
                        (
                                rs.getInt("id") +  "\t" +
                                rs.getString("Name") + "\t" +
                                rs.getInt("Price") + "\t" +
                                rs.getInt("Stock")
                        );
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SelectTable app = new SelectTable();
        app.selectAll();
    }
    
    /**
    *
    * @author JON ANDER ARANA
    * @param select all rows in table
    */
  
    public void selectAll2()
    {
        String sql = "SELECT id, Name, password,IsAdmin FROM User";

        try
                (
                        Connection conn = this.connect();
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
            while (rs.next())
            {
                System.out.println
                        (
                                rs.getInt("id") +  "\t" +
                                rs.getString("Name") + "\t" +
                                rs.getString("password")+ "\t" + 
                                rs.getInt("IsAdmin")
                        );
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    /**
    *
    * @author JON ANDER ARANA
    * @param select all rows in table
    */
  
    public void selectAll3()
    {
        String sql = "SELECT idOrder, totalpaid,idUser FROM OrderRecord";

        try
                (
                        Connection conn = this.connect();
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
            while (rs.next())
            {
                System.out.println
                        (
                                rs.getInt("idOrder") +  "\t" +
                                rs.getInt("totalpaid") + "\t" +
                                rs.getInt("idUser")
                        );
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
    *
    * @author JON ANDER ARANA
    * @param select all rows in table
    */
  
    public void selectAll4()
    {
        String sql = "SELECT idProduct,idO,quantityProduct,OrderDate FROM ORDERPRODUCT";

        try
                (
                        Connection conn = this.connect();
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
            while (rs.next())
            {
                System.out.println
                        (
                                rs.getInt("idProduct") +  "\t" +
                                rs.getInt("idO") + "\t" +
                                rs.getInt("quantityProduct")+ "\t"+
                                rs.getInt("OrderDate")
                            
                        );
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    /**
    *
    * @author JON ANDER ARANA
    * @param select all rows in table
    */
}
