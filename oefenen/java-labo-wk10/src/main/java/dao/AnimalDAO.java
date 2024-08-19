package dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Animal;
import entity.AnimalType;
import util.HibernateUtil;

public class AnimalDAO {

    public void create(Animal animal) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(animal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Animal> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s FROM Animal s", Animal.class).list();
        }
    }

    public boolean existAnimal(String name, AnimalType type, String owner) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Animal> animals = session.createQuery("SELECT s FROM Animal s WHERE s.name = '" + name + "'", Animal.class).list();
            return animals.size() > 0;
        }
    }

    public Optional<Animal> findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Animal.class, id));
        }
    }
}
