package Main.DAL;


import Main.Entities.maintenance.MaintenanceStaff;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


/**
 * Created by Jackson on 2/8/14.
 */
public class MaintenanceStaffDAO implements IMaintenanceStaffDAO {


    @Override
    public MaintenanceStaff create(MaintenanceStaff newStaffMember) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(newStaffMember);
        session.getTransaction().commit();
        session.close();
        return newStaffMember;


    }

    @Override
    public void delete(MaintenanceStaff maintenanceStaff) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.delete(maintenanceStaff);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public MaintenanceStaff get(int id) {
        try {
            Session session = DatabaseConnector.connect();
            session.beginTransaction();
            Query getCustQuery = session.createQuery("From MaintenanceStaffImpl where id=:id");
            getCustQuery.setInteger("id", id);

            List staff = getCustQuery.list();

            session.getTransaction().commit();
            session.close();
            return (MaintenanceStaff)staff.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public MaintenanceStaff update(MaintenanceStaff updatedStaffMember) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(updatedStaffMember);
        session.getTransaction().commit();
        session.close();
        return updatedStaffMember;
    }
}
