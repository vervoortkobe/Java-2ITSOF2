package dao;

import entity.Beer;
import entity.Natuurpark;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class NatuurparkDAO {
    public void create(Natuurpark natuurpark) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(natuurpark);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Natuurpark> toonNatuurparken() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT b FROM Natuurpark b", Natuurpark.class).list();
        }
    }

    public Natuurpark findNatuurpark(String naam) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Natuurpark.class, naam);
        }
    }
}