package org.rabbit.dblayer;

import org.hibernate.Session;
import org.rabbit.model.User;

public class UserManager {
    public static User addUser(User user){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }

}
