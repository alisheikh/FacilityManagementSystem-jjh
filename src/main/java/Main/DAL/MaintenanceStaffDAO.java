package Main.DAL;


import Main.Entities.Facility.Facility;
import Main.Entities.maintenance.MaintenanceStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Jackson on 2/8/14.
 */
public class MaintenanceStaffDAO implements IMaintenanceStaffDAO {


    private IDatabaseConnector connector;
    private Connection connection;

    public MaintenanceStaffDAO(IDatabaseConnector connector){
        this.connector = connector;

        connection = connector.connect();
    }

    @Override
    public MaintenanceStaff Create(MaintenanceStaff newStaffMember) {
            String createQuery = "INSERT INTO maintenance_staff(" +
                    "first_name, last_name, phone_number, email_address, pay_per_hour," +
                    "is_full_time, hours_per_week)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement insertStatement = connection.prepareStatement(createQuery, java.sql.Statement.RETURN_GENERATED_KEYS);
                insertStatement.setString(1,newStaffMember.getFirstName());
                insertStatement.setString(2,newStaffMember.getLastName());
                insertStatement.setString(3,newStaffMember.getPhoneNumber());
                insertStatement.setString(4,newStaffMember.getEmailAddress());
                insertStatement.setDouble(5, newStaffMember.getPayPerHour());
                insertStatement.setBoolean(6, newStaffMember.isFullTime());
                insertStatement.setDouble(7, newStaffMember.getHoursPerWeek());

                int affectedRows = insertStatement.executeUpdate();
                if (affectedRows == 0) {
                    throw new SQLException("Creating user failed, no rows affected.");
                }

                 ResultSet result = insertStatement.getGeneratedKeys();

                if(result.next())
                {
                    newStaffMember.setID(result.getInt(4));//todo if we ever rebuild the database reorder tables so id is the first column

                }
                else {
                    throw new SQLException("Creating user failed, no generated key obtained.");
                }

                insertStatement.close();

            }

            catch (SQLException e) {
                e.printStackTrace();
                return null;
            }

        return newStaffMember;


    }

    @Override
    public void Delete(int staffMemberId) {
        String deleteQuery = "DELETE FROM maintenance_staff WHERE id =?";

        try {
            PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setInt(1,staffMemberId);
            deleteStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        MaintenanceStaff maintenanceStaff = new MaintenanceStaff();
    }

    @Override
    public MaintenanceStaff Get(int id) throws SQLException {
        String getQuery = "Select * FROM maintenance_staff where id = ?";

        PreparedStatement getStatement = connection.prepareStatement(getQuery);
        getStatement.setInt(1, id);


        MaintenanceStaff maintenanceStaff = new MaintenanceStaff();
        try {
            ResultSet rs = getStatement.executeQuery();
            if (rs.next()) {

                maintenanceStaff.setID(rs.getInt("id"));
                maintenanceStaff.setFirstName(rs.getString("first_name"));
                maintenanceStaff.setLastName(rs.getString("last_name"));
                maintenanceStaff.setFullTime(rs.getBoolean("is_full_time"));
                maintenanceStaff.setPayPerHour(rs.getDouble("pay_per_hour"));
                maintenanceStaff.setPhoneNumber(rs.getString("phone_number"));
                maintenanceStaff.setEmailAddress(rs.getString("email_address"));
                maintenanceStaff.setHoursPerWeek(rs.getInt("hours_per_week"));

            }
            else
            {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return maintenanceStaff;

    }

    @Override
    public MaintenanceStaff Update(MaintenanceStaff updatedStaffMember) {
        return null;
    }
}
