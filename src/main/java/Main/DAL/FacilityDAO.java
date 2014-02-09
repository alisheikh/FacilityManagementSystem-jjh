package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;
import org.joda.time.DateTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityDAO implements IFacilityDAO {

    private IDatabaseConnector Connector;
    private Connection connection;

    public FacilityDAO(IDatabaseConnector connector) {
       Connector = connector;
       connection = connector.connect();
    }

    @Override
    public Facility create(Facility facilty) {
        return null;
    }

    @Override
    public Facility update(Facility facility) {
        return null;
    }

    @Override
    public void delete(int id) {

	}

	@Override
    public Facility get(int id) {
        Facility facility = new Facility();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM Facilities where id = "+id);
            while (rs.next()) {
                facility.setID(id);
                facility.setBuildingNumber(rs.getInt("building_number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Unit> units = new ArrayList<Unit>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM Facilities where id = "+id);
            while (rs.next()) {
                facility.setID(id);
                facility.setBuildingNumber(rs.getInt("building_number"));
            }


            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        facility.setUnits(units);
        return facility;
    }

    @Override
    public Unit getUnit(int unitID) {
        return null;
    }

    @Override
    public Unit CreateUnitForFacility(int FacilityID, Unit newUnit) {
        return null;
    }

    @Override
    public void DeleteUnit(Unit unit) {

    }

    @Override
    public Unit UpdateUnit(Unit unit) {
        return null;
    }

    private List<Unit> getUnitsForFacility(int facilityID)
    {
        List<Unit> units = new ArrayList<Unit>();
        String getQuery = "Select*FROM Units where facility_id = ?";
        try {
            PreparedStatement getStatement = connection.prepareStatement(getQuery);
            getStatement.setInt(1,facilityID);

            ResultSet rsUnits = getStatement.executeQuery();

            while (rsUnits.next()) {
                Unit unit = new Unit();
                unit.setCapacity(rsUnits.getInt("capacity"));
                unit.setId(rsUnits.getInt("id"));
                unit.setRoomNumber(rsUnits.getInt("roomNumber"));
                //unit.setUsage(getUsages(unit.getRoomNumber()));
                units.add(unit);
            }
            rsUnits.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return units;

    }



    //todo refactor
    public List<UnitUsage> getUsages(int unitNumber){
        List<UnitUsage> usages = new ArrayList<UnitUsage>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM Usages where Unit = "+unitNumber);
            while (rs.next()) {
                UnitUsage usage = new UnitUsage();
                usage.setId(rs.getInt("id"));
                //usage.setUnit(getUnit());
                usage.setStartTime(rs.getDate("start_time"));
                usage.setEndTime(rs.getDate("end_time"));

                //TODO: Rest of Fields
                usages.add(usage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usages;
    }
    //todo refactor
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
