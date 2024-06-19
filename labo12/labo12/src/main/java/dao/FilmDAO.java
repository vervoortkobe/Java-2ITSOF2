package dao;

import entity.Film;
import entity.Regisseur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmDAO {
    public void createNew(Film film) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(film);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public List<Film> findYear(int year) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT f from Film f", Film.class)
                    .stream()
                    .filter(o -> o.getUitgaveJaar().getYear() == year)
                    .collect(Collectors.toList());
        }
    }

    public List<Film> findTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT f from Film f", Film.class)
                    .stream()
                    .filter(o -> o.getTitel().equals(title))
                    .collect(Collectors.toList());
        }
    }

    public List<Film> findRegisseur(Regisseur regisseur) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT f from Film f", Film.class)
                    .stream()
                    .filter(o -> o.getRegisseurs().equals(regisseur))
                    .collect(Collectors.toList());
        }
    }

    public List<String> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT f from Film f", Film.class)
                    .stream()
                    .map(Film::getTitel)
                    .collect(Collectors.toList());
        }
    }
}
