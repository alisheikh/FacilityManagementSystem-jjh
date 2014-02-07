package Main.DAL;

/**
 * User: alexthornburg
 * Date: 2/4/14
 * Time: 7:07 PM
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    static Connection connection = null;

    public DatabaseConnector(){

    }

    public static Connection connect(){
        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://ec2-54-204-27-119.compute-1.amazonaws.com:5432/d8bdfjiqldja8v", "kzprhsuuhaqamu",
                    "CtkuwQTL2G3Mpv_cajVqzH_tNh");

        } catch (ClassNotFoundException e) {

            System.out.println("No Driver");
            e.printStackTrace();
            return null;

        }catch (SQLException e) {

            System.out.println("Sql problem");
            e.printStackTrace();
            return null;

        }
        return connection;

    }
}
