package util;

import entity.Animal;
import entity.Donation;
import entity.Donor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate-h2.cfg.xml");
            configuration.addAnnotatedClass(Animal.class);
            configuration.addAnnotatedClass(Donor.class);
            configuration.addAnnotatedClass(Donation.class);

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
