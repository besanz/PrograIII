package db;

import java.sql.*;
import java.util.ArrayList;

import data.User;

public class SelectUser {

    /**
     * @auhor Benat
     * @return
     */

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
     * @author Benat
     * Receiving users from database
     */

    public static ArrayList<User> selectUser()
    {
        String sql = "SELECT id, Name, password,IsAdmin FROM User";
        ArrayList<User> users = new ArrayList<User>();

        try
                (
                        Connection conn = connect();
                        Statement stmt  = conn.createStatement();
        				ResultSet rs    = stmt.executeQuery(sql);
                )
        {
        	

            while (rs.next())
            {
            	boolean esAdmin=false;
                if (rs.getInt("IsAdmin")==1){
                	esAdmin=true;
                }
                        User u = new User ( rs.getInt("id"),rs.getString("Name"),rs.getString("password"), esAdmin);
                        users.add(u);
                
                       
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public static void main(String[]args){
    	ArrayList<User> u= SelectUser.selectUser();
    	System.out.println(u);
    }
    
   
}
