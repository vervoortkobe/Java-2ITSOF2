package be.ap.wk7.starwars.dao;

import be.ap.wk7.starwars.troopers.StormTrooper;
import be.ap.wk7.starwars.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class StormTrooperDAO {

    public List<StormTrooper> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<StormTrooper> query = session.createQuery("SELECT s FROM StormTrooper s", StormTrooper.class);
            return query.list();
        }
    }

    public Optional<StormTrooper> findById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(StormTrooper.class, id));
        }
    }

    public void createNew(StormTrooper trooper) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(trooper);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void update(StormTrooper trooper) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.merge(trooper);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void delete(StormTrooper trooper) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.remove(trooper);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }
}
