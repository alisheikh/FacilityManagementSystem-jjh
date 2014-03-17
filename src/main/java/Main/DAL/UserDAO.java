package Main.DAL;

import Main.Entities.usage.UnitUsage;
import Main.Entities.usage.UnitUser;
import Main.Entities.usage.UnitUserImpl;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.*;
import java.util.List;


/**
 * Created by Jackson on 2/10/14.
 */


public class UserDAO implements IUserDAO {
    @Override
    public UnitUser create(UnitUser user) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        return user;


    }

    @Override
    public void delete(UnitUser user) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();


    }

    @Override
    public UnitUser get(int id) {
        try {
            Session session = DatabaseConnector.connect().getCurrentSession();
            session.beginTransaction();
            Query getUnitQuery = session.createQuery("From unit_user where id=:id");
            getUnitQuery.setString("id", String.valueOf(id));

            List unitUser = getUnitQuery.list();

            session.getTransaction().commit();
            return (UnitUser)unitUser.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public UnitUser update(UnitUser user) {
        Session session = DatabaseConnector.connect().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        return user;
    }
}
