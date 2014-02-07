package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;
import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityDAO {

    Connection connection = DatabaseConnector.connect();

	public FacilityDAO create(Facility facilty) {
        return null;
    }

	public FacilityDAO update(Facility facility) {
        return null;
    }

	public void delete(int id) {

	}

	public Facility get(String id) {
        Facility facility = new Facility();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM Facilities where id = "+id);
            while (rs.next()) {
                facility.setID(id);
                facility.setBuildingNumber(Integer.parseInt(rs.getString("buildingNumber")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Unit> units = new ArrayList<Unit>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM Facilities where id = "+id);
            while (rs.next()) {
                facility.setID(id);
                facility.setBuildingNumber(Integer.parseInt(rs.getString("buildingNumber")));
            }

            ResultSet rsUnits = connection.createStatement().executeQuery("Select*FROM Units where Facility = "+facility.getBuildingNumber());

            while (rsUnits.next()) {
                Unit unit = new Unit();
                unit.setCapacity(rs.getInt("capacity"));
                unit.setId(id);
                unit.setRoomNumber(rs.getInt("roomNumber"));
                unit.setUsage(getUsages(unit.getRoomNumber()));
                unit.setUsers(getUsers(unit.getRoomNumber()));
                units.add(unit);
            }
            rs.close();
            rsUnits.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        facility.setUnits(units);
        return facility;
    }

    public List<UnitUsage> getUsages(int unitNumber){
        List<UnitUsage> usages = new ArrayList<UnitUsage>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM Usages where Unit = "+unitNumber);
            while (rs.next()) {
                UnitUsage usage = new UnitUsage();
                usage.setEndTime(DateTime.parse(rs.getDate("endTime").toString()));

                //TODO: Rest of Fields
                usages.add(usage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usages;
    }

    public List<UnitUser> getUsers(int unitNumber){
        List<UnitUser> users = new ArrayList<UnitUser>();
        try {
        ResultSet rs = connection.createStatement().executeQuery("Select*FROM Users where Unit = "+unitNumber);
            while (rs.next()) {
                UnitUser user = new UnitUser();
                user.setID(unitNumber);
                user.setFirstName(rs.getString("firstName"));
                //TODO: Rest of Fields
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }


    public List<Facility> getAll() {
        return null;
    }
}
