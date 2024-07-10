package test;

import model.Profile;
import model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        // Tạo và lưu một User với Profile tương ứng
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Profile profile = new Profile("User's profile");
            User user = new User("03nmt");
            user.setProfile(profile);
            profile.setUser(user);

            session.save(user);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
