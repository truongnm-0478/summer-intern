package test;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.sql.Date;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        if(sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
//            Person ha_cuong_thinh = new Person("Ha Cuong Thinh", new Date(2003, 7, 26), null);
//            session.save(ha_cuong_thinh);

//            Person ha_cuong_thinh = session.find(Person.class, 1L);
//            Person nguyen_minh_anh = new Person("Nguyen Minh Anh", new Date(System.currentTimeMillis()), ha_cuong_thinh);
//            session.save(nguyen_minh_anh);

            Person ha_cuong_thinh = session.find(Person.class, 1L);
            Person nguyen_minh_anh = session.find(Person.class, 2L);

            ha_cuong_thinh.setPartner(nguyen_minh_anh);
            session.saveOrUpdate(ha_cuong_thinh);


            transaction.commit();
            session.close();
        }
    }
}
