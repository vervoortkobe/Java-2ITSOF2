package DAO;

import Entity.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CarDAO {
    private static SessionFactory factory;
    public CarDAO() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
    public Integer addCar(Car car)
    {
        Transaction transaction = null;
        Integer id = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();

            id =(Integer) session.save(car);

            transaction.commit();
        } catch (Exception e) {

            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }

        return id;
    }


    public void updateCar(Car car, int id) {
        car.setId(id);
        Transaction transaction = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();

            session.update(car);

            transaction.commit();
        } catch (Exception e) {

            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }

    }

    public void deleteCar(int id)
    {
        Car car = new Car();
        car.setId(id);
        Transaction transaction = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();

            session.delete(car);

            transaction.commit();
        } catch (Exception e) {

            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Car> getCars(){
        try( Session session = factory.openSession()){
            return session.createQuery("from Car", Car.class).list();
        }
    }
}
