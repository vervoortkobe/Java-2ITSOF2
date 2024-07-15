package dao;

import hibernate.HibernateUtil;
import model.Prediction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PredictionDAO {
    public List<Prediction> getPredictions() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return  session.createQuery("SELECT p FROM Prediction p", Prediction.class).list();
        }
    }

    public Optional<Prediction> getPredictionById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return  Optional.of(session.get(Prediction.class, id));
        }
    }

    public void addPrediction(Prediction prediction) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(prediction);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }
}
