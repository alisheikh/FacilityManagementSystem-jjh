package Main.DAL;

/**
 * User: alexthornburg
 * Date: 2/4/14
 * Time: 7:07 PM
 */

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnector {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory connect(){

     return sessionFactory;

    }

    public static void diconnect() {
        sessionFactory.close();
    }
}
