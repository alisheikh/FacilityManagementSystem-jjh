package Main.DAL;

import Main.Entities.usage.UnitUser;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


/**
 * Created by Jackson on 2/10/14.
 */


public class UserDAO implements IUserDAO {
    @Override
    public UnitUser create(UnitUser user) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;


    }

    @Override
    public void delete(UnitUser user) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public UnitUser get(int id) {
        try {
            Session session = DatabaseConnector.connect();
            session.beginTransaction();
            Query getUnitQuery = session.createQuery("From UnitUsageImpl where id=:id");
            getUnitQuery.setInteger("id", id);

            List unitUser = getUnitQuery.list();

            session.getTransaction().commit();
            session.close();
            return (UnitUser)unitUser.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public UnitUser update(UnitUser user) {
        Session session = DatabaseConnector.connect();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }
}
