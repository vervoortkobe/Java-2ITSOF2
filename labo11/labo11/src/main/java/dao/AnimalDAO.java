package dao;

import entity.Animal;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class AnimalDAO {
    public AnimalDAO() {}

    public void createNew(Animal animal) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(animal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public List<String> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT p from Animal p", Animal.class).stream().map(p -> p.getName() + ": " + p.getEndangered()).toList();
        }
    }
}
