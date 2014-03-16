package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.FacilityImpl;
import Main.Entities.Facility.Unit;
import Main.Entities.Facility.UnitImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityDAO implements IFacilityDAO {

    private IDatabaseConnector connector;
    private Connection connection;
    private IUnitDAO unitDAO;

    public FacilityDAO() {

    }

    @Override
    public Facility create(Facility facility) {
        String createQuery = "INSERT INTO facility (name,capacity,building_number) VALUES (?,?,?)";

        try {

            PreparedStatement insertStatement = connection.prepareStatement(createQuery, java.sql.Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, facility.getName());
            insertStatement.setInt(2, facility.getCapacity());
            insertStatement.setInt(3, facility.getBuildingNumber());


            int affectedRows = insertStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            ResultSet result = insertStatement.getGeneratedKeys();

            if(result.next())
            {
                facility.setId(result.getInt("id"));


                List<Unit> units  = facility.getUnits();

                for(Unit u:units){
                    u.setFacilityId(facility.getId());
                }

                unitDAO.CreateUnit(units);
            }
            else {
                throw new SQLException("Creating user failed, no generated key obtained.");
            }

            insertStatement.close();
            result.close();


            return facility;

        }

        catch (Exception e) {
            e.printStackTrace();
            return facility;
        }

    }

    @Override
    public Facility update(Facility facility) {
        for(Unit unit:facility.getUnits()){
            Unit check = getUnit(unit.getId());
            if(check.getId()==0){
                try{

                    try {
                        unitDAO.CreateUnit(unit);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }




                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        }
        try {
            connection.createStatement().executeUpdate("UPDATE facility" +
                    " SET (name,capacity,building_number)"+
                    "= ('"+facility.getName()+"','"+facility.getCapacity()+"','"+facility.getBuildingNumber()+"')" +
                    "WHERE id = "+facility.getId());

            for(Unit unit:facility.getUnits()){
                unit = unitDAO.UpdateUnit(unit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return facility;
    }

    @Override
    public void delete(Facility facility) {


        String deleteQuery = "DELETE FROM facility WHERE id = ?";

        try {
            PreparedStatement getStatement = connection.prepareStatement(deleteQuery);
            getStatement.setInt(1,facility.getId());

            getStatement.executeUpdate();

            getStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

            //todo add throw??
        }


	}

	@Override
    public Facility get(int id) {
        Facility facility = new FacilityImpl();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM facility where id = '"+id+"'");
            while (rs.next()) {
                facility.setId(rs.getInt("id"));
                facility.setName(rs.getString("name"));
                facility.setBuildingNumber(rs.getInt("building_number"));
                facility.setCapacity(rs.getInt("capacity"));
                facility.setUnits(getUnitsForFacility(rs.getInt("id")));
            }

            facility.setUnits(unitDAO.GetUnitForFacility(facility.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facility;
    }

    private List<Unit> getUnitsForFacility(int facilityId)
    {
        List<Unit> units = new ArrayList<Unit>();


        try {
            return unitDAO.GetUnitForFacility(facilityId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return units;


    }



    @Override
    public List<Facility> getAll() {
        List<Facility> facilities = new ArrayList<Facility>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select * FROM facility");
            while (rs.next()) {
                Facility facility = new FacilityImpl();
                facility.setId(rs.getInt("id"));
                facility.setName(rs.getString("name"));
                facility.setBuildingNumber(rs.getInt("building_number"));
                facility.setCapacity(rs.getInt("capacity"));
                facility.setUnits(getUnitsForFacility(rs.getInt("id")));

                facility.setUnits(unitDAO.GetUnitForFacility(facility.getId()));

                facilities.add(facility);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilities;
    }

    @Override
    public Unit getUnit(int unitId){
        try {
            return unitDAO.GetUnit(unitId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new UnitImpl();
    }

    public IDatabaseConnector getConnector() {
        return connector;
    }

    public void setConnector(IDatabaseConnector connector) {
        this.connector = connector;
        connection = connector.connect();
    }

    public void setUnitDAO(IUnitDAO unitDAO) {
        this.unitDAO = unitDAO;
    }
}
