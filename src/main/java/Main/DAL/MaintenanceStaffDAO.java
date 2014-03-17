package Main.DAL;


import Main.Entities.maintenance.MaintenanceRequest;
import Main.Entities.maintenance.MaintenanceStaff;
import Main.Entities.maintenance.MaintenanceStaffImpl;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.*;
import java.util.List;


/**
 * Created by Jackson on 2/8/14.
 */
public class MaintenanceStaffDAO implements IMaintenanceStaffDAO {


    @Override
    public MaintenanceStaff create(MaintenanceStaff newStaffMember) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(newStaffMember);
        session.getTransaction().commit();

        return newStaffMember;


    }

    @Override
    public void delete(MaintenanceStaff maintenanceStaff) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.delete(maintenanceStaff);
        session.getTransaction().commit();


    }

    @Override
    public MaintenanceStaff get(int id) {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();
            Query getCustQuery = session.createQuery("From maintenance_staff where id=:id");
            getCustQuery.setString("id", String.valueOf(id));

            List staff = getCustQuery.list();

            session.getTransaction().commit();
            return (MaintenanceStaff)staff.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public MaintenanceStaff update(MaintenanceStaff updatedStaffMember) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(updatedStaffMember);
        session.getTransaction().commit();

        return updatedStaffMember;
    }
}
