package Main.client;

import Main.DAL.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * User: alexthornburg
 * Date: 2/6/14
 * Time: 10:54 PM
 */
public class CreateTables {

    public static void main(String[] args){
        Connection connection = DatabaseConnector.connect();
        /*try {
            connection.createStatement().executeQuery("CREATE TABLE Facility (" +
                    "id varchar (25) PRIMARY KEY," +
                    "buildingNumber int NOT NULL" +
                    ")");

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }*/
        printTables(connection);
    }

    public static void printTables(Connection connection){
        try {
            ResultSet rs =connection.createStatement().executeQuery("SELECT * FROM information_schema.tables ");
            while (rs.next()) {
                System.out.println(rs.getString(3)+"\t"+rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
