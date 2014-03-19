package Main.DAL;

import Main.Entities.Facility.Unit;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public class UnitDAO implements IUnitDAO {



    @Override
    public Unit create(Unit unit) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(unit);
        session.getTransaction().commit();

        session.close();
        return unit;


    }

    @Override
    public void delete(Unit unit) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.delete(unit);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Unit get(int id) {
        try {
            Session session = DatabaseConnector.connect();
            session.beginTransaction();
            Unit unit = (Unit)session.byId(String.valueOf(id));
            session.getTransaction().commit();
            session.close();
            return unit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Unit update(Unit unit) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(unit);
        session.getTransaction().commit();
        session.close();
        return unit;
    }

    @Override
    public List<Unit> getAll(int facilityId) {
        System.out.println("Listing all facilities");
        Session session = DatabaseConnector.connect();
        System.out.println("Session ready: "+session.toString());
        Query query = session.createQuery("from UnitImpl where facility.facilityId =:facilityId");
        query.setInteger("facilityId",facilityId);
        List<Unit> units;
        session.beginTransaction();
        units = query.list();
        session.close();
        return units;
    }



}
