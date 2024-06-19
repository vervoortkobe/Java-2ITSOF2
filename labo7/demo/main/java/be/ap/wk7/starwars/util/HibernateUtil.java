package be.ap.wk7.starwars.util;


import be.ap.wk7.starwars.troopers.StormTrooper;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate-h2.cfg.xml");
            configuration.addAnnotatedClass(StormTrooper.class);

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

}
