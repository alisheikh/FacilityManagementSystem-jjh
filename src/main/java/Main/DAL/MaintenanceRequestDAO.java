package Main.DAL;


import Main.Entities.maintenance.MaintenanceRequest;

import java.sql.*;


public class MaintenanceRequestDAO implements IMaintenanceRequestDAO {

    //TODO:This is where we execute our sql statements.

    private IDatabaseConnector connector;
    private Connection connection;
    private IFacilityDAO facilityDAO;
    private IMaintenanceStaffDAO maintenanceStaffDAO;

    public MaintenanceRequestDAO(IDatabaseConnector connector, IFacilityDAO facilityDAO, IMaintenanceStaffDAO maintenanceStaffDAO) {
        this.connector = connector;
        this.facilityDAO = facilityDAO;
        this.maintenanceStaffDAO = maintenanceStaffDAO;

        connection = connector.connect();
    }

    @Override
    public MaintenanceRequest create(MaintenanceRequest request)
    {

        String createQuery = " INSERT INTO maintenance_request(request, date_requested, completion_date, staff_member_assigned_id," +
                         "unit_id) VALUES (?, ?, ?, ?, ?);";


        try {
            PreparedStatement createStatement = connection.prepareStatement(createQuery, java.sql.Statement.RETURN_GENERATED_KEYS);
            createStatement.setString(1, request.getRequest());
            createStatement.setDate(2, request.getDateRequested());
            createStatement.setDate(3, null);
            createStatement.setInt(4, request.getStaffMemberAssigned().getID());
            createStatement.setInt(5, request.getUnit().getId());


           int affectedRows = createStatement.executeUpdate();

            ResultSet rs = createStatement.getGeneratedKeys();
           if(rs.next())
           {
              request.setID(rs.getInt("id"));
              rs.close();
               createStatement.close();
              return request;
           }
        } catch (SQLException e) {
         //   e.printStackTrace();

        }
        return null;
    }

	@Override
    public MaintenanceRequest update(MaintenanceRequest request) {
        return null;
	}

	@Override
    public void delete(int ID) {
        String deleteQuery = "DELETE FROM maintenance_request WHERE id = ?";



        MaintenanceRequest request = null;
        try {
            PreparedStatement getStatement = connection.prepareStatement(deleteQuery);
            getStatement.setInt(1,ID);

            ResultSet rs = getStatement.executeQuery();
            rs.close();
            getStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

            //todo add throw??
        }



	}

	@Override
    public MaintenanceRequest get(int ID)
    {
        String getQuery = "SELECT * FROM maintenance_request where id =? ";

        MaintenanceRequest request = new MaintenanceRequest();
        try {
            PreparedStatement getStatement = connection.prepareStatement(getQuery);
            getStatement.setInt(1,ID);


            ResultSet rs = getStatement.executeQuery();
            if(rs.next())
            {
                request.setDateRequested(rs.getDate("date_requested"));
                request.setID(rs.getInt("id"));
                request.setRequest(rs.getString("request"));
                request.setUnit(facilityDAO.getUnit(rs.getInt("unit_id")));
                request.setStaffMemberAssigned(maintenanceStaffDAO.get(rs.getInt("staff_member_assigned_id")));
                request.setCompletionDate(rs.getDate("completion_date"));
                rs.close();
                getStatement.close();
                return request;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


		return null;
	}

}
