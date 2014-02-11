package Main.DAL;

import Main.BL.FacilityService;
import Main.Entities.maintenance.Inspection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InspectionDAO {

    private Connection connection;

    public InspectionDAO() {
        connection = DatabaseConnector.connect();
    }

	public Inspection create(Inspection inspection) {
        try {
            Statement statement = connection.createStatement();
            String query1 = "INSERT INTO inspection " +
                    " (id,facility_id,inspection_staff_id,inspection_date)"+
                    "VALUES ('"+inspection.getID()+"','"+inspection.getFacility().getID()+"','"
                    +inspection.getInspectingStaffID()+"','"+inspection.getInspectionDate()+"')";
            System.out.println(query1);
            statement.executeUpdate(query1);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inspection;
	}

	public Inspection update(Inspection inspection)
    {
        try{
            Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE inspection" +
                    " SET (id,facility_id,inspection_staff_id,inspection_date)"+
                    "= ('"+inspection.getID()+"','"+inspection.getFacility().getID()+"','"+inspection.getInspectingStaffID()+
                        "','"+inspection.getInspectionDate()+"')" +
                    "WHERE id = "+inspection.getID());
            statement.close();
            return inspection;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

	}

	public void delete(int id) {
        try {
            Statement statement = connection.createStatement();
                statement.executeUpdate("DELETE FROM inspection where id = '"+id+"'");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	public Inspection get(int id) {
        Inspection result = new Inspection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM inspection where id = "+id);
            while (rs.next()) {
                result.setID(rs.getInt("id"));
                result.setInspectingStaffID(rs.getInt("inspection_Staff_id"));
                result.setInspectionDate(rs.getDate("inspection_date"));
                result.setFacility(new FacilityService().getFacilityInformation(rs.getInt("facility_id")));
            }
            statement.close();
            return result;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

    public List<Inspection> listAllInspections(){
        List<Inspection> inspections = new ArrayList<Inspection>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM inspection");
            while (rs.next()) {
                Inspection result = new Inspection();
                result.setID(rs.getInt("id"));
                result.setInspectingStaffID(rs.getInt("inspection_Staff_id"));
                result.setInspectionDate(rs.getDate("inspection_date"));
                result.setFacility(new FacilityService().getFacilityInformation(rs.getInt("facility_id")));
                inspections.add(result);
            }
            statement.close();
            return inspections;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
