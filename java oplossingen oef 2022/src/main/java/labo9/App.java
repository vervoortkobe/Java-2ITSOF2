package labo9;

import labo9.DAO.StudentDAO;
import labo9.entity.Student;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class App {

    public static void main(String[] args) {

        StudentDAO studentDAL = new StudentDAO();

        Integer id = studentDAL.addStudent(new Student("Mohammed", "Souleymane", "testqq"));
        Integer id2 = studentDAL.addStudent(new Student("Mohamed", "Saadi", "tessdfqtqq"));
        Integer id3 = studentDAL.addStudent(new Student("Stef", "Santens", "tessdfqtqq"));
        studentDAL.Update(new Student("Mohammed","Meiyaki","sdfqds"),id);


        studentDAL.Delete(id2);
        List<Student> students = studentDAL.getStudents();
        students.forEach(s -> System.out.println(s.getLastName()));
    }
}
