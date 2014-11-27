package org.rabbit.dblayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rabbit.model.Twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        // NOTICE: reading the correct config is important
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
//        try {
//            // Create the SessionFactory from hibernate.cfg.xml
//            return new Configuration().configure().buildSessionFactory(
//                    new StandardServiceRegistryBuilder().build() );
//        }
//        catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static List<Twitter> twitters = new ArrayList<Twitter>();

    static {
        Twitter twitter = new Twitter();
        twitter.setUid(112);
        twitter.setText("Test");
        twitters.add(twitter);
    }

    public static void addTwitter(Twitter twitter){
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(twitter);
        session.getTransaction().commit();
    }

    public static boolean removeTwitter(Twitter twitter){
        Session session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(twitter);
        session.getTransaction().commit();
        return true;
    }

    public static Twitter[] getTwitters(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Twitter").list();
        session.getTransaction().commit();

        List<Twitter> twitters=new ArrayList<Twitter>();
        for (Object obj:result){
            twitters.add((Twitter)obj);
        }
        return twitters.toArray(new Twitter[twitters.size()]);
    }

    public static void main(String[] args){
        Twitter twitter=new Twitter();
        twitter.setText("test");
        twitter.setCreatedDate(new Date());
        twitter.setUid(1234);

        addTwitter(twitter);
    }
}
