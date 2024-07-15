package labo9.DAO;

import labo9.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDAO {
    private static SessionFactory factory;
    public StudentDAO() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
    public Integer addStudent(Student student)
    {
        Transaction transaction = null;
        Integer id = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();

            id =(Integer) session.save(student);

            transaction.commit();
        } catch (Exception e) {

            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }

        return id;
    }


    public void Update(Student student, int id) {
        student.setId(id);
        Transaction transaction = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();

            session.update(student);

            transaction.commit();
        } catch (Exception e) {

            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }

    }

    public void Delete(int id)
    {
        Student student = new Student();
        student.setId(id);
        Transaction transaction = null;
        try (Session session = factory.openSession()){
            transaction = session.beginTransaction();

            session.delete(student);

            transaction.commit();
        } catch (Exception e) {

            if(transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Student> getStudents(){
        try( Session session = factory.openSession()){
            return session.createQuery("from Student", Student.class).list();
        }
    }
}
