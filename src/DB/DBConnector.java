package DB;

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
    public void insertProduct(int id,String name,int price )
    {
        String sql = "INSERT INTO Product(id,name,price) VALUES(?,?)";

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
     * @isAdmin 
     */
    public void insertUser(int id,String name,int price )
    {
        String sql = "INSERT INTO Product(id,name,price) VALUES(?,?)";

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

}
	

