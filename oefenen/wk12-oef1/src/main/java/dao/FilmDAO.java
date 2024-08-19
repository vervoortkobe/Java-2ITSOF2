package dao;

import entity.Film;
import entity.Regisseur;
import exceptions.JaarInToekomstException;
import exceptions.RegisseurNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    public List<String> findYear(int year) throws JaarInToekomstException {
        if(LocalDate.of(year, 1, 1).isAfter(LocalDate.now())) throw new JaarInToekomstException("Het ingegeven jaar is in de toekomst. Dit kan niet. Probeer opnieuw.");

       try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT f from Film f", Film.class)
                    .stream()
                    .filter(f -> f.getUitgaveJaar().getYear() == year)
                    .map(f -> String.format("%s – %s – %s",
                            f.getTitel(),
                            f.getDatumToegevoegd().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            f.getOmschrijving()))
                    .collect(Collectors.toList());
        }
    }

    public List<String> findTitle(String title) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT f.title FROM Film f WHERE f.title LIKE :title", String.class)
                    .setParameter("title", "%" + title + "%")
                    .getResultList();
        }
    }

    public List<String> findRegisseur(String regisseurNaam) throws RegisseurNotFoundException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<String> films = session.createQuery("SELECT f FROM Film f", Film.class)
                    .stream()
                    .filter(film -> film.getRegisseurs().stream()
                            .anyMatch(r -> r.getNaam().equalsIgnoreCase(regisseurNaam)))
                    .map(film -> String.format("%s – %s – %s",
                            film.getTitel(),
                            film.getUitgaveJaar(),
                            film.getRegisseurs().stream()
                                    .map(Regisseur::getNaam)
                                    .collect(Collectors.joining(", "))))
                    .collect(Collectors.toList());

            if (films.isEmpty()) {
                throw new RegisseurNotFoundException("Geen films gevonden voor regisseur: " + regisseurNaam);
            }

            return films;
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
