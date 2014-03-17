package Main.DAL;

import Main.Entities.usage.UnitUsage;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Jackson on 2/10/14.
 */
public class UsageDAO implements IUsageDAO {



    @Override
    public UnitUsage create(UnitUsage usage) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(usage);
        session.getTransaction().commit();

        return usage;


    }

    @Override
    public void delete(UnitUsage usage) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.delete(usage);
        session.getTransaction().commit();


    }

    @Override
    public List<UnitUsage> getAll() {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();
            Query getUnitQuery = session.createQuery("From UnitUsage");
            List unitUsage = getUnitQuery.list();

            session.getTransaction().commit();
            return unitUsage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UnitUsage get(int id) {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();
            Query getUnitQuery = session.createQuery("From unit_usage where id=:id");
            getUnitQuery.setString("id", String.valueOf(id));

            List unitUsage = getUnitQuery.list();

            session.getTransaction().commit();
            return (UnitUsage)unitUsage.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public UnitUsage update(UnitUsage usage) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(usage);
        session.getTransaction().commit();

        return usage;
    }
}
