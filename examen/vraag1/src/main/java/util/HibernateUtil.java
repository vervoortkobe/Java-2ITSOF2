package util;

import entity.Beer;
import entity.Natuurpark;
import entity.Waarneming;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Beer.class);
                configuration.addAnnotatedClass(Natuurpark.class);
                configuration.addAnnotatedClass(Waarneming.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}