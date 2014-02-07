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
         Connection connection = DatabaseConnector.GetConnection();
        try {
            if(connection.isValid(500)) System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
