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
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(usage);
        session.getTransaction().commit();
        session.close();
        return usage;


    }

    @Override
    public void delete(UnitUsage usage) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.delete(usage);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public List<UnitUsage> getAll() {
        try {
            Session session = DatabaseConnector.connect();
            session.beginTransaction();
            Query getUnitQuery = session.createQuery("From UnitUsageImpl");
            List unitUsage = getUnitQuery.list();

            session.getTransaction().commit();
            session.close();
            return unitUsage;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UnitUsage get(int id) {
        try {
            Session session = DatabaseConnector.connect();
            session.beginTransaction();
            Query getUnitQuery = session.createQuery("From UnitUsageImpl where id=:id");
            getUnitQuery.setInteger("id", id);

            List unitUsage = getUnitQuery.list();

            session.getTransaction().commit();
            session.close();
            return (UnitUsage)unitUsage.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public UnitUsage update(UnitUsage usage) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(usage);
        session.getTransaction().commit();
        session.close();
        return usage;
    }
}
