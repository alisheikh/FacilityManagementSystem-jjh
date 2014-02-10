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
    public Facility create(Facility facility) {
        try {
            String query1 = "INSERT INTO facility " +
                    " (name,capacity,id,building_number)"+
                    "VALUES ('"+facility.getName()+"','"+facility.getCapacity()+"','"
                    +facility.getID()+"','"+facility.getBuildingNumber()+"')";
            System.out.println(query1);
            connection.createStatement().executeUpdate(query1);
            for(Unit unit:facility.getUnits()){
                String query2 =  "INSERT INTO unit " +
                        "(id,facility_id,capacity,unit_number)" +
                        "VALUES ('"+unit.getId()+"','"+unit.getFacilityId()+"','"+unit.getCapacity()+"','"+
                        unit.getRoomNumber()+"')";
                System.out.println(query2);
               connection.createStatement().executeUpdate(query2);
                System.out.println(query2);
                for(UnitUser user:unit.getUsers()){
                    String query3 = "INSERT INTO unit_user " +
                            "(first_name,last_name,phone_number,id,email_address,credit_card,company_name) " +
                            "VALUES ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getPhoneNumber()+
                            "','"+user.getID()+"','"+user.getEmailAddress()+"','"+user.getCreditCard()+
                            "','"+user.getCompanyName()+"')";
                    connection.createStatement().executeUpdate(query3);
                }
                for(UnitUsage usage:unit.getUsage()){
                    String query4 = "INSERT INTO unit_usage " +
                            "(id,unit_id,start_time,end_time,unit_user_id)" +
                            "VALUES ('"+usage.getId()+"','"+usage.getUnitId()+"','"+usage.getStartTime()+"','"+
                            usage.getEndTime()+"','"+usage.getUserId()+"')";
                    System.out.println(query4);
                    connection.createStatement().executeUpdate(query4);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facility;
    }

    @Override
    public Facility update(Facility facility) {
        for(Unit unit:facility.getUnits()){
            Unit check = getUnit(unit.getId());
            if(check.getId()==0){
                try{
                    String query2 =  "INSERT INTO unit " +
                            "(id,facility_id,capacity,unit_number)" +
                            "VALUES ('"+unit.getId()+"','"+unit.getFacilityId()+"','"+unit.getCapacity()+"','"+
                            unit.getRoomNumber()+"')";
                    System.out.println(query2);
                    connection.createStatement().executeUpdate(query2);
                    for(UnitUser user:unit.getUsers()){
                        String query3 = "INSERT INTO unit_user " +
                                "(first_name,last_name,phone_number,id,email_address,credit_card,company_name) " +
                                "VALUES ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getPhoneNumber()+
                                "','"+user.getID()+"','"+user.getEmailAddress()+"','"+user.getCreditCard()+
                                "','"+user.getCompanyName()+"')";
                        connection.createStatement().executeUpdate(query3);
                    }
                    for(UnitUsage usage:unit.getUsage()){
                        String query4 = "INSERT INTO unit_usage " +
                                "(id,unit_id,start_time,end_time,unit_user_id)" +
                                "VALUES ('"+usage.getId()+"','"+usage.getUnitId()+"','"+usage.getStartTime()+"','"+
                                usage.getEndTime()+"','"+usage.getUserId()+"')";
                        System.out.println(query4);
                        connection.createStatement().executeUpdate(query4);
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
        try {
            connection.createStatement().executeUpdate("UPDATE facility" +
                    " SET (name,capacity,building_number)"+
                    "= ('"+facility.getName()+"','"+facility.getCapacity()+"','"+facility.getBuildingNumber()+"')" +
                    "WHERE id = "+facility.getID());
            for(Unit unit:facility.getUnits()){
                String updateUnits = "UPDATE unit" +
                        " SET (facility_id,capacity,unit_number)" +
                        "= ('"+unit.getFacilityId()+"','"+unit.getCapacity()+"','"+
                        unit.getRoomNumber()+"')" +
                        "WHERE id = "+unit.getId();
                System.out.println(updateUnits);
                connection.createStatement().executeUpdate(updateUnits);
                for(UnitUser user:unit.getUsers()){
                    connection.createStatement().executeUpdate("UPDATE unit_user " +
                            " SET (first_name,last_name,phone_number,email_address,credit_card,company_name)" +
                            "= ('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getPhoneNumber()+"','"+
                            user.getEmailAddress()+"','"+user.getCreditCard()+"','"+user.getCompanyName()+"')" +
                            "WHERE id ="+user.getID());
                }
                for(UnitUsage usage:unit.getUsage()){
                    connection.createStatement().executeUpdate("UPDATE unit_usage" +
                            " SET (id,unit_id,start_time,end_time,unit_user_id)" +
                            "= ('"+usage.getId()+"','"+usage.getUnitId()+"','"+usage.getStartTime()+"','"+
                            usage.getEndTime()+"','"+usage.getUserId()+"')" +
                            "WHERE id = "+usage.getUserId());
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facility;
    }

    @Override
    public void delete(Facility facility) {
        try {
            connection.createStatement().executeUpdate("DELETE FROM facility where id = '"+facility.getID()+"'");
            for(Unit unit:facility.getUnits()){
                connection.createStatement().executeUpdate("DELETE FROM unit where id = '"+unit.getId()+"'");
                for(UnitUser user:unit.getUsers()){
                    connection.createStatement().executeUpdate("DELETE FROM unit_user where id = '"+user.getID()+"'");
                }
                for(UnitUsage usage:unit.getUsage()){
                    connection.createStatement().executeUpdate("DELETE FROM unit_usage where id = '"+usage.getId()+"'");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


	}

	@Override
    public Facility get(int id) {
        Facility facility = new Facility();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM facility where id = '"+id+"'");
            while (rs.next()) {
                facility.setID(rs.getInt("id"));
                facility.setName(rs.getString("name"));
                facility.setBuildingNumber(rs.getInt("building_number"));
                facility.setCapacity(rs.getInt("capacity"));
                facility.setUnits(getUnitsForFacility(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facility;
    }

    private List<Unit> getUnitsForFacility(int facilityId)
    {
        List<Unit> units = new ArrayList<Unit>();
        String getQuery = "Select*FROM unit where facility_id = '" +facilityId+"'";
        try {
            PreparedStatement getStatement = connection.prepareStatement(getQuery);
            ResultSet rsUnits = getStatement.executeQuery();

            while (rsUnits.next()) {
                Unit unit = new Unit();
                unit.setCapacity(rsUnits.getInt("capacity"));
                unit.setId(rsUnits.getInt("id"));
                unit.setRoomNumber(rsUnits.getInt("unit_number"));
                unit.setFacilityId(rsUnits.getInt("facility_id"));
                unit.setUsage(getUsages(rsUnits.getInt("id")));
                unit.setUsers(getUsers(rsUnits.getInt("id")));
                units.add(unit);
            }
            rsUnits.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return units;

    }


    public List<UnitUsage> getUsages(int unitId){
        List<UnitUsage> usages = new ArrayList<UnitUsage>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM unit_usage where unit_id = '"+unitId+"'");
            while (rs.next()) {
                UnitUsage usage = new UnitUsage();
                usage.setId(rs.getInt("id"));
                //usage.setUnit(getUnit());
                usage.setStartTime(DateTime.parse(rs.getDate("start_time").toString()));
                usage.setEndTime(DateTime.parse(rs.getDate("end_time").toString()));
                usage.setUnitId(rs.getInt("unit_id"));
                usage.setUserId(rs.getInt("unit_user_id"));
                usages.add(usage);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usages;
    }


    public List<UnitUser> getUsers(int userId){
        List<UnitUser> users = new ArrayList<UnitUser>();
        try {
        ResultSet rs = connection.createStatement().executeQuery("Select*FROM unit_user where id = "+userId);
            while (rs.next()) {
                UnitUser user = new UnitUser();
                user.setFirstName(rs.getString("first_name"));
                user.setID(rs.getInt("id"));
                user.setCompanyName(rs.getString("company_name"));
                user.setCreditCard(rs.getString("credit_card"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setLastName(rs.getString("last_name"));
                user.setPhoneNumber(rs.getInt("phone_number"));
                users.add(user);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;

    }


    public List<Facility> getAll() {
        List<Facility> facilities = new ArrayList<Facility>();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM facility");
            while (rs.next()) {
                Facility facility = new Facility();
                facility.setID(rs.getInt("id"));
                facility.setName(rs.getString("name"));
                facility.setBuildingNumber(rs.getInt("building_number"));
                facility.setCapacity(rs.getInt("capacity"));
                facility.setUnits(getUnitsForFacility(rs.getInt("id")));
                facilities.add(facility);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facilities;
    }

    @Override
    public Unit getUnit(int unitId){
        Unit unit = new Unit();
        try {
            ResultSet rs = connection.createStatement().executeQuery("Select*FROM unit where id = '"+unitId+"'");
            while (rs.next()) {
                unit.setFacilityId(rs.getInt("facility_id"));
                unit.setId(rs.getInt("id"));
                unit.setRoomNumber(rs.getInt("unit_number"));
                unit.setCapacity(rs.getInt("capacity"));
                unit.setUsers(getUsers(rs.getInt("id")));
                unit.setUsage(getUsages(rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return unit;
    }
}
