package Main.DAL;


import Main.Entities.Facility.Unit;
import Main.Entities.maintenance.MaintenanceRequest;
import Main.Entities.maintenance.MaintenanceRequestImpl;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MaintenanceRequestDAO implements IMaintenanceRequestDAO {


    @Override
    public MaintenanceRequest create(MaintenanceRequest request)
    {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(request);
        session.getTransaction().commit();

        return request;
    }

	@Override
    public MaintenanceRequest update(MaintenanceRequest request) throws Exception {
        /*String updateQuery = "UPDATE maintenance_request SET request=?, date_requested=?," +
                " completion_date=?, staff_member_assigned_id=?, unit_id=?, hours_to_complete = ? WHERE id = ?";

        System.out.println("StaffMember Assigned ID in DAO"+ request.getStaffMemberAssigned().getId());


        try {
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            updateStatement.setString(1, request.getRequest());
            updateStatement.setDate(2, request.getDateRequested());
            updateStatement.setDate(3, request.getCompletionDate());
            updateStatement.setInt(4, request.getStaffMemberAssigned().getId());
            updateStatement.setInt(5, request.getUnit().getId());
            updateStatement.setDouble(6, request.getHoursToComplete());
            updateStatement.setInt(7, request.getId());


            int affectedRows = updateStatement.executeUpdate();

           if(affectedRows == 1)
           {
               request = get(request.getId());
               return request;
           }
           
        } catch (SQLException e) {
            e.printStackTrace();

        }*/
        return request;
    }

	@Override
    public void delete(MaintenanceRequest request) {

        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.delete(request);
        session.getTransaction().commit();

	}

    /*
    * @return maintenance request
    * null if no records are found
    * */
	@Override
    public MaintenanceRequest get(int id)
    {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();

            //System.out.println("*************** Hibernate session is created ..................\n" + session.toString());

            //Query getCustQuery = session.createQuery("From CustomerImpl ");
            Query getCustQuery = session.createQuery("From maintenance_request where id=:id");
            getCustQuery.setString("id", String.valueOf(id));

            List customers = getCustQuery.list();
            System.out.println("Getting Book Details using HQL. \n" + customers);

            session.getTransaction().commit();
            return (MaintenanceRequest)customers.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

	}

    /*@Override
    public List<MaintenanceRequest> getAllForUnit(Unit unit)
    {
        String getQuery = "SELECT * FROM maintenance_request where unit_id =? ";

        List<MaintenanceRequest> maintenanceRequests = new ArrayList<MaintenanceRequest>();
        try {
            PreparedStatement getStatement = connection.prepareStatement(getQuery);
            getStatement.setInt(1,unit.getId());


            ResultSet rs = getStatement.executeQuery();
            while(rs.next())
            {

                MaintenanceRequestImpl request = new MaintenanceRequestImpl();

                request.setDateRequested(rs.getDate("date_requested"));
                request.setId(rs.getInt("id"));
                request.setRequest(rs.getString("request"));
                request.setUnit(facilityDAO.getUnit(rs.getInt("unit_id")));
                request.setStaffMemberAssigned(maintenanceStaffDAO.get(rs.getInt("staff_member_assigned_id")));
                request.setCompletionDate(rs.getDate("completion_date"));
                request.setHoursToComplete(rs.getInt("hours_to_complete"));


                maintenanceRequests.add(request);

            }
            rs.close();
            getStatement.close();
            return maintenanceRequests;

        }
            catch (SQLException e) {
            e.printStackTrace();
            }

            return maintenanceRequests;
    }

    public void setFacilityDAO(IFacilityDAO facilityDAO) {
        this.facilityDAO = facilityDAO;
    }

    public void setMaintenanceStaffDAO(IMaintenanceStaffDAO maintenanceStaffDAO) {
        this.maintenanceStaffDAO = maintenanceStaffDAO;
    }*/
}
