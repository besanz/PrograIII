package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {

    /**
     * @Author Benat
     */
    public static void createNewTable(String sql) throws SQLException {
        String name = "BaseDeDatos.db";
        String url = "jdbc:sqlite"+name;

        try (Connection conn= DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();)
        {
            stmt.execute(sql);}
        catch(SQLException e){
            System.out.println("An error has occurred: "+e);
        }

    }



}
