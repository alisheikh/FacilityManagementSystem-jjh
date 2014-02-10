package Main.DAL;

import Main.BL.FacilityService;
import Main.Entities.maintenance.Inspection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InspectionDAO {

    private Connection connection;

    public InspectionDAO(IDatabaseConnector connector) {
        connection = connector.connect();
    }

	public Inspection create(Inspection inspection) {
        try {
            String query1 = "INSERT INTO inspection " +
                    " (id,facility_id,inspection_staff_id,inspection_date)"+
                    "VALUES ('"+inspection.getID()+"','"+inspection.getFacility().getID()+"','"
                    +inspection.getInspectingStaffID()+"','"+inspection.getInspectionDate()+"')";
            System.out.println(query1);
            connection.createStatement().executeUpdate(query1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inspection;
	}

	public Inspection update(Inspection inspection)
    {
        try{
                connection.createStatement().executeUpdate("UPDATE inspection" +
                    " SET (id,facility_id,inspection_staff_id,inspection_date)"+
                    "= ('"+inspection.getID()+"','"+inspection.getFacility().getID()+"','"+inspection.getInspectingStaffID()+
                        "','"+inspection.getInspectionDate()+"')" +
                    "WHERE id = "+inspection.getID());
            return inspection;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return null;

	}

	public void delete(int id) {
        try {
            connection.createStatement().executeUpdate("DELETE FROM inspection where id = '"+id+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	public Inspection get(int id) {
        Inspection result = new Inspection();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM inspection where id = "+id);
            while (rs.next()) {
                result.setID(rs.getInt("id"));
                result.setInspectingStaffID(rs.getInt("inspection_Staff_id"));
                result.setInspectionDate(rs.getDate("inspection_date"));
                result.setFacility(new FacilityService().getFacilityInformation(rs.getInt("facility_id")));
            }
            return result;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}

    public List<Inspection> listAllInspections(){
        List<Inspection> inspections = new ArrayList<Inspection>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM inspection");
            while (rs.next()) {
                Inspection result = new Inspection();
                result.setID(rs.getInt("id"));
                result.setInspectingStaffID(rs.getInt("inspection_Staff_id"));
                result.setInspectionDate(rs.getDate("inspection_date"));
                result.setFacility(new FacilityService().getFacilityInformation(rs.getInt("facility_id")));
                inspections.add(result);
            }
            return inspections;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
