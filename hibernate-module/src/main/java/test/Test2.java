package test;

import model.Department;
import model.Employee;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Tạo một phòng ban mới
            Department department = new Department();
            department.setName("IT");
            session.save(department);

            // Tạo một nhân viên mới thuộc về phòng ban IT
            Employee employee = new Employee();
            employee.setName("Ngo Mau Truong");
            employee.setDepartment(department);
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
