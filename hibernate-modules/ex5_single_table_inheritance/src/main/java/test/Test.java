package test;

import model.Customer;
import model.Employee;
import model.Person;
import org.hibernate.SessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Customer customer = new Customer(1, "Cu Thi Huyen Trang", "silver");
            Employee employee = new Employee(1, "Ngo Mau Truong", "IT");

            session.save(customer);
            session.save(employee);

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
