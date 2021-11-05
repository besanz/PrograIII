package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    private static String dbName;
    private static Connection conn;

    /**
     * Method to connect DataBase
     * @param dbName Name of DB without including the extension
     */
    public static void connect(String dbName){
        DBUtils.dbName = dbName;
        try{
            DriverManager.getConnection("jdbc:sqlite" + dbName + ".db");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Method to disconnect the database
     */
    public static void disconnect(){
        try{
            DBUtils.conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
