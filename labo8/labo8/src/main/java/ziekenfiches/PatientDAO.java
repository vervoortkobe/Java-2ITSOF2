package ziekenfiches;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PatientDAO {
    public void createNew(Patient patient) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(patient);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
        }
    }

    public List<String> getAllPatients() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT p from Patient p", Patient.class).stream().map(p -> p.getId() + ": " + p.getName() + ", " + p.getType()).toList();
        }
    }
}
