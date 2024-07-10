package test;

import model.Employee;
import model.Meeting;
import org.hibernate.SessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Employee employee1 = new Employee("EV001", "Ngo Mau Truong", new Date(2003, 7, 27));
//            session.save(employee1);
//            Employee employee2 = new Employee("EV002", "Ha Cuong Thinh", new Date(2003, 7, 26));

            Meeting meeting1 = new Meeting();
            meeting1.setName("Daily meeting");
            meeting1.setDate(new Date(2025, 6, 28));
            meeting1.setLocation("Room 1");
            meeting1.addEmployee(employee1);

            session.save(meeting1);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
