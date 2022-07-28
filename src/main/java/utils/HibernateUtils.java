package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    static {
    	sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public static SessionFactory getSessionfactory() {
    	return sessionFactory;
    }

}
