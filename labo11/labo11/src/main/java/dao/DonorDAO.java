package dao;

import entity.Animal;
import entity.Donor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class DonorDAO {
    public DonorDAO() {}

    public void createNew(Donor donor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(donor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public List<String> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT p from Donor p", Donor.class).stream().map(p -> p.getName() + ": " + p.getCompany()).toList();
        }
    }
}
