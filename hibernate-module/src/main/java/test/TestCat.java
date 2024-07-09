package test;

import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class TestCat {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

            if(sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    Transaction transaction = session.beginTransaction();
                    Cat cat1 = new Cat();
                    cat1.setName("Tom");
                    cat1.setSex(true);
                    session.save(cat1);
                    transaction.commit();
                } finally {
                    session.close();
                }
            }
        }
        catch (Exception e) {

        }

    }
}
