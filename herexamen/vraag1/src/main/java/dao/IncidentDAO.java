package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import entity.Locatie;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Incident;
import entity.IncidentType;
import util.HibernateUtil;

public class IncidentDAO {

    public void createNew(Incident incident) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(incident);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Incident> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s FROM Incident s", Incident.class).list();
        }
    }

    public boolean existIncident(LocalDate datumtijd, Locatie locatie, IncidentType type, String slachtoffer) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Incident> incidents = session.createQuery("SELECT s FROM Incident s WHERE s.datumtijd = '" + datumtijd + "'", Incident.class).list();
            return incidents.size() > 0;
        }
    }

    public Optional<Incident> findById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Incident.class, id));
        }
    }

    public List<Incident> sortByDatumTijdDesc() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT s FROM Incident s ORDER BY s.datumtijd desc", Incident.class).list();
        }
    }
}
