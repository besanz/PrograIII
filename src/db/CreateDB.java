package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {
    /**
     *
     * @param dbName es el nombre de la base de datos que se quiere crear
     */
    public static void createNewDatabase(String dbName)
    {

        String url = "jdbc:sqlite:"+ dbName;
        try (Connection conn = DriverManager.getConnection(url)){
            if (conn != null){
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args)
    {
        createNewDatabase("BaseDeDatos.db");
    }
}