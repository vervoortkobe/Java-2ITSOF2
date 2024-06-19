package dao;

import entity.Film;
import entity.Regisseur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;
import java.util.stream.Collectors;

public class RegisseurDAO {
    public void createNew(Regisseur regisseur) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(regisseur);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public List<Regisseur> findRegisseur(String naam) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT r from Regisseur r", Regisseur.class)
                    .stream()
                    .filter(o -> o.getNaam().equals(naam))
                    .collect(Collectors.toList());
        }
    }
}
