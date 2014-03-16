package Main.DAL;

import Main.Entities.Facility.Unit;
import Main.Entities.Facility.UnitImpl;
import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUsageImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public class UnitDAO implements IUnitDAO {



    private IDatabaseConnector connector;
    private Connection connection;


    public UnitDAO(){

    }

    public UnitDAO(IDatabaseConnector connector) {

        this.connector = connector;
        connection = connector.connect();
    }

    public IDatabaseConnector getConnector() {
        return connector;
    }

    public void setConnector(IDatabaseConnector connector) {
        this.connector = connector;
        connection = connector.connect();
    }


    @Override
    public void CreateUnit(List<Unit> units) throws SQLException {
        for(Unit unit:units){
            CreateUnit(unit);

            /*
            List<UnitUsage> usages = unit.getUsages();
            for(UnitUsage usage:usages){
                userDAO.Create(usage.getUnitUser());
                CreateUsage(usage);
            }*/
        }
    }

    @Override
    public Unit CreateUnit(Unit unit) throws SQLException {
        String createQuery = "INSERT INTO unit(facility_id, capacity, unit_number) VALUES (?, ?, ?)";


        try {
            PreparedStatement createStatement = connection.prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS);

            createStatement.setInt(1, unit.getFacilityId());
            createStatement.setInt(2, unit.getCapacity());
            createStatement.setInt(3, unit.getUnitNumber());


            int affectedRows = createStatement.executeUpdate();

            ResultSet rs = createStatement.getGeneratedKeys();
            if(rs.next())
            {
                unit.setId(rs.getInt("id"));
                rs.close();
                createStatement.close();

                return unit;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return unit;

    }

    @Override
    public Unit GetUnit(int unit_id) throws SQLException {
        String getQuery = "Select * FROM unit where id = ?";

        Unit unit = new UnitImpl();
        try {
            PreparedStatement getStatement = connection.prepareStatement(getQuery);
            getStatement.setInt(1, unit_id);
            ResultSet rs = getStatement.executeQuery();
            if (rs.next()) {

               unit.setId(rs.getInt("id"));
               unit.setCapacity(rs.getInt("capacity"));
               unit.setFacilityId(rs.getInt("facility_id"));
               unit.setUnitNumber(rs.getInt("unit_number"));


                rs.close();
                getStatement.close();}
            else {
                rs.close();
                getStatement.close();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return unit;

    }

    @Override
    public Unit UpdateUnit(Unit unit) throws Exception {
        String updateQuery = "UPDATE unit SET facility_id=?, capacity=?, unit_number=? WHERE id =?";




        try {
            PreparedStatement createStatement = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);

            createStatement.setInt(1, unit.getFacilityId());
            createStatement.setInt(2, unit.getCapacity());
            createStatement.setInt(3, unit.getUnitNumber());
            createStatement.setInt(4, unit.getId());



            int affectedRows = createStatement.executeUpdate();

            if(affectedRows == 1)
            {
                unit = GetUnit(unit.getId());
                return unit;
            }
            else
            {
                throw new Exception("UpdateUnit Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return unit;
    }

    @Override
    public List<Unit> GetUnitForFacility(int facilityId) throws SQLException {
        String getQuery = "Select * FROM unit where facility_id = ?";
        List<Unit> units = new ArrayList<Unit>();

        try {
            PreparedStatement getStatement = connection.prepareStatement(getQuery);
            getStatement.setInt(1, facilityId);
            ResultSet rs = getStatement.executeQuery();

            while (rs.next()) {

                Unit unit = new UnitImpl();

                int iddd = rs.getInt("id");
                unit.setId(rs.getInt("id"));
                unit.setCapacity(rs.getInt("capacity"));
                unit.setFacilityId(rs.getInt("facility_id"));
                unit.setUnitNumber(rs.getInt("unit_number"));

                units.add(unit);


            }
            rs.close();
            getStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return units;

    }

    @Override
    public void DeleteUnit(int id) {

        String deleteQuery = "DELETE FROM unit WHERE id = ?";

        try {
            PreparedStatement getStatement = connection.prepareStatement(deleteQuery);
            getStatement.setInt(1,id);

            getStatement.executeUpdate();

            getStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();

            //todo add throw??
        }

    }



}
