package Main.DAL;

import Main.Entities.Facility.Facility;
import Main.Entities.Facility.Unit;
import Main.Entities.Facility.UnitImpl;
import Main.Entities.maintenance.MaintenanceStaff;
import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUsageImpl;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public class UnitDAO implements IUnitDAO {



    @Override
    public Unit create(Unit unit) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(unit);
        session.getTransaction().commit();

        return unit;


    }

    @Override
    public void delete(Unit unit) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.delete(unit);
        session.getTransaction().commit();


    }

    @Override
    public Unit get(int id) {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();
            Query getUnitQuery = session.createQuery("From unit where id=:id");
            getUnitQuery.setString("id", String.valueOf(id));

            List unit = getUnitQuery.list();

            session.getTransaction().commit();
            return (Unit)unit.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Unit update(Unit unit) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(unit);
        session.getTransaction().commit();

        return unit;
    }

    @Override
    public List<Unit> getAll(int facilityId) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        Query query = session.createQuery("from facility where facility_id=facilityId");
        List<Unit> units = new ArrayList<Unit>();
        session.beginTransaction();
        units = query.list();
        return units;
    }



}
