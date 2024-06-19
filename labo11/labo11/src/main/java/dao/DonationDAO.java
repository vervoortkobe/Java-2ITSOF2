package dao;

import entity.Animal;
import entity.Donation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class DonationDAO {
    public DonationDAO() {}

    public void createNew(Donation donation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(donation);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public List<String> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT p from Donation p", Donation.class).stream().map(p -> p.getDonor() + ": " + p.getAmount() + ", " + p.getAnimal() + ", " + p.getDate()).toList();
        }
    }
}
