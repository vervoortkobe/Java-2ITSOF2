package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Animal;
import entity.Consult;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Animal.class);
                configuration.addAnnotatedClass(Consult.class);
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}