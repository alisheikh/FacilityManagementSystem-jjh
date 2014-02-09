package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.MaintenanceRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceRequestDAO {

    //TODO:This is where we execute our sql statements.

    private IDatabaseConnector connector;
    private Connection connection;

    public MaintenanceRequestDAO(IDatabaseConnector connector) {
        this.connector = connector;

        connection = connector.connect();
    }

    public MaintenanceRequest create(MaintenanceRequest request) {

            String createQuery = "Insert into";

                    return null;
    }

	public MaintenanceRequest update(MaintenanceRequest request) {
        return null;
	}

	public void delete(int ID) {

	}

	public MaintenanceRequest get(int ID) {
		return null;
	}

}
