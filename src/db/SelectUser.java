package db;

import java.sql.*;

public class SelectUser {

    /**
     * @auhor Benat
     * @return
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
     * @author Benat
     * Receiving users from database
     */

    public void selectUser()
    {
        String sql = "SELECT id, Name, password,IsAdmin FROM User";

        try
                (
                        Connection conn = this.connect();
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {


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
}
