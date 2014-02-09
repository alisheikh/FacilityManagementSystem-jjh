package Main.DAL;

/**
 * User: alexthornburg
 * Date: 2/4/14
 * Time: 7:07 PM
 */

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector implements IDatabaseConnector {
    static Connection connection = null;

    public DatabaseConnector(){

    }



    @Override
    public Connection connect(){
        try {

            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://ec2-54-204-27-119.compute-1.amazonaws.com:5432/d8bdfjiqldja8v?user=kzprhsuuhaqamu&password=CtkuwQTL2G3Mpv_cajVqzH_tNh&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            connection = DriverManager.getConnection(url);

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
