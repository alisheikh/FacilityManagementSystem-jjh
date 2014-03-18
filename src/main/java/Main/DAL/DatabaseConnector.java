package Main.DAL;

/**
 * User: alexthornburg
 * Date: 2/4/14
 * Time: 7:07 PM
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnector {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session connect(){


      return   sessionFactory.openSession();




    }

    public static void diconnect() {
        sessionFactory.close();
    }
}
