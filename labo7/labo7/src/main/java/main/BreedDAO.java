package main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class BreedDAO {
    public void createNew(Breed breed) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(breed);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Breed> findAllBreeds() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT b FROM Breed b", Breed.class).list();
        }
    }
}