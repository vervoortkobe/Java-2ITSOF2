package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Consult;
import util.HibernateUtil;

public class ConsultDAO {

    public void create(Consult consult) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(consult);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Consult> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s FROM Consult s", Consult.class).list();
        }
    }
}
