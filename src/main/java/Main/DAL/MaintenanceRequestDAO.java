package Main.DAL;


import Main.Entities.maintenance.MaintenanceRequest;

import java.sql.*;


public class MaintenanceRequestDAO implements IMaintenanceRequestDAO {

    //TODO:This is where we execute our sql statements.

    private IDatabaseConnector connector;
    private Connection connection;

    public MaintenanceRequestDAO(IDatabaseConnector connector) {
        this.connector = connector;

        connection = connector.connect();
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest request)
    {

        String getQuery = " INSERT INTO maintenance_request(request, date_requested, completion_date, staff_member_assigned_id," +
                         "unit_id) VALUES (?, ?, ?, ?, ?);";


        try {
            PreparedStatement getStatement = connection.prepareStatement(getQuery);
            getStatement.setString(1,request.getRequest());
            getStatement.setDate(2, request.getDateRequested());
            getStatement.setDate(3, null);
            getStatement.setInt(4, request.getStaffMemberAssigned().getID());
            getStatement.setInt(5, request.getUnit().getId());


           ResultSet rs = getStatement.executeQuery();
           if(rs.next())
           {
              request.setID(rs.getInt("id"));
               return request;
           }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

	@Override
    public MaintenanceRequest update(MaintenanceRequest request) {
        return null;
	}

	@Override
    public void delete(int ID) {

	}

	@Override
    public MaintenanceRequest get(int ID) {


		return null;
	}

}
