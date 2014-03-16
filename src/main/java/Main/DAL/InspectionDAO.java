package Main.DAL;

import Main.BL.IFacilityService;
import Main.Entities.maintenance.Inspection;
import Main.Entities.maintenance.InspectionImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InspectionDAO implements IInspectionDAO {

    private IDatabaseConnector connector;
    private Connection connection;
    private IFacilityDAO facilityDAO;
    private IMaintenanceStaffDAO maintenanceStaffDAO;

    public InspectionDAO() {

    }

	@Override
    public Inspection create(Inspection inspection) {
        try {
            String createQuery = "INSERT INTO inspection(facility_id, " +
                    "inspection_staff_id, inspection_date) VALUES (?, ?, ?)";


            PreparedStatement createStatement = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);
            createStatement.setInt(1, inspection.getFacility().getId());
            createStatement.setInt(2, inspection.getInspectingStaff().getId());
            createStatement.setDate(3, inspection.getInspectionDate());

            int rowsAffected = createStatement.executeUpdate();

            if(rowsAffected == 1)
            {
                ResultSet resultSet = createStatement.getGeneratedKeys();
                if(resultSet.next()){
                inspection.setId(resultSet.getInt("id"));
            }
            }
            else
            {
                //do something to tell that there was nothing retunred ie there was an error?
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return inspection;
	}

	@Override
    public Inspection update(Inspection inspection)
    {
        try{
                connection.createStatement().executeUpdate("UPDATE inspection" +
                    " SET (id,facility_id,inspection_staff_id,inspection_date)"+
                    "= ('"+inspection.getId()+"','"+inspection.getFacility().getId()+"','"+inspection.getInspectingStaff().getId()+
                        "','"+inspection.getInspectionDate()+"')" +
                    "WHERE id = "+inspection.getId());
            return inspection;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

	}

	@Override
    public void delete(int id) {
        try {
            connection.createStatement().executeUpdate("DELETE FROM inspection where id = '"+id+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	@Override
    public Inspection get(int id) {
        Inspection result = new InspectionImpl();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM inspection where id = "+id);
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setInspectingStaff(maintenanceStaffDAO.get(rs.getInt("inspection_Staff_id")));
                result.setInspectionDate(rs.getDate("inspection_date"));
                result.setFacility(facilityDAO.get(rs.getInt("facility_id")));
            }
            return result;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

    @Override
    public List<Inspection> listAllInspections(int facilityID){
        List<Inspection> inspections = new ArrayList<Inspection>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM inspection where facility_id ="+facilityID);


            while (rs.next()) {
                Inspection result = new InspectionImpl();
                result.setId(rs.getInt("id"));
                result.setInspectingStaff(maintenanceStaffDAO.get(rs.getInt("inspection_Staff_id")));
                result.setInspectionDate(rs.getDate("inspection_date"));
                result.setFacility(facilityDAO.get(rs.getInt("facility_id")));
                inspections.add(result);
            }
            return inspections;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return inspections;
    }

    @Override
    public IDatabaseConnector getConnector() {
        return connector;
    }

    @Override
    public void setConnector(IDatabaseConnector connector) {
        this.connector = connector;
        connection = connector.connect();
    }

     @Override
     public void setMaintenanceStaffDAO(IMaintenanceStaffDAO maintenanceStaffDAO) {
        this.maintenanceStaffDAO = maintenanceStaffDAO;
    }

    @Override
    public void setFacilityDAO(IFacilityDAO facilityDAO) {
        this.facilityDAO = facilityDAO;
    }
}
