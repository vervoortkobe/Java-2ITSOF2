package dao;

import entity.Beer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class BeerDAO {
    public void create(Beer beer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(beer);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Beer> toonBeren() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT b FROM Beer b ORDER BY b.naam ", Beer.class).list();
        }
    }
}
