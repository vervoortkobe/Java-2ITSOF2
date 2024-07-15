package dao;

import model.WeatherStation;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class WeatherStationDAO {
    public List<WeatherStation> getWeatherStations() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return  session.createQuery("SELECT w FROM WeatherStation w", WeatherStation.class).list();
        }
    }

    public Optional<WeatherStation> getWeatherStationById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return  Optional.of(session.get(WeatherStation.class, id));
        }
    }

    public Optional<WeatherStation> getWeatherStationByName(String name) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT w FROM WeatherStation w WHERE LOWER(w.name) = '"+name.toLowerCase()+"'", WeatherStation.class).uniqueResultOptional();
        }
    }

    public void addWeatherStation(WeatherStation weatherStation) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(weatherStation);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                transaction.rollback();
        }
    }

    public boolean exists(String name) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return  (session.createQuery("SELECT w FROM WeatherStation w WHERE LOWER(w.name) = '"+name.toLowerCase()+"'", WeatherStation.class).list().size() != 0);
        }
    }
}
