package Main.client;

/**
 * User: alexthornburg
 * Date: 2/4/14
 * Time: 7:17 PM
 */
import Main.DAL.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){


        DatabaseConnector connector = new DatabaseConnector();
        Connection connection = connector.connect();
        try {
            connection.createStatement().executeQuery("Select*FROM Users where Unit = ");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
