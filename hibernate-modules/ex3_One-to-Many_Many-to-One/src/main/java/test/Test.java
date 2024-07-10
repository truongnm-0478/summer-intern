package test;

import model.Department;
import model.Employee;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Tạo một phòng ban mới
            Department department = new Department();
            department.setName("IT");

            // Tạo một nhân viên mới thuộc về phòng ban IT
            Employee employee1 = new Employee();
            employee1.setName("Nguyen Gia Bao");
            department.addEmployee(employee1);

            Employee employee2 = new Employee();
            employee2.setName("Nguyen Duc Dung");
            department.addEmployee(employee2);

            session.save(department);

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
