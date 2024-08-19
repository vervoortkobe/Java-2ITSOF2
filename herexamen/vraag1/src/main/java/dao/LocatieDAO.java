package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Locatie;
import util.HibernateUtil;

public class LocatieDAO {

    public void createNew(Locatie locatie) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(locatie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Locatie> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s FROM Locatie s", Locatie.class).list();
        }
    }

    public List<Locatie> sortByNameAndTypeBear() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s FROM Locatie s ORDER BY s.naam, ORDER BY s.type", Locatie.class).list();
        }
    }
}
