package db;

import data.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUser {

    /**
     * Connect to the test.db database
     * @author Benat
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
     * @author Benat
     * Inserting user to the database
     * @param idUser
     * @param username
     * @param password
     * @param isAdmin
     */

    public void insertUser (int idUser, String username, String password, boolean isAdmin)
    {
        String sql = "INSERT INTO User(id, Name, password,IsAdmin) VALUES(?,?,?,?)";

        try
                (
                        Connection conn = this.connect();
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {
            pstmt.setInt(1, idUser);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setBoolean(2, isAdmin);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        User u = new User(1, "test", "test", true);


        DBConnector app = new DBConnector();
        app.insertUser(u.getIdUser(), u.getUsername(), u.getPassword(), u.isAdmin() );
        System.out.println(u);

    }



}
