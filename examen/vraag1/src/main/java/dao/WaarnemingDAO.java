package dao;

import entity.Natuurpark;
import entity.Waarneming;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;

public class WaarnemingDAO {
    public void create(Waarneming waarneming) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(waarneming);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Waarneming> toonWaarnemingen() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT b FROM Waarneming b", Waarneming.class).list();
        }
    }
}
