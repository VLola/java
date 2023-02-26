package controllers;

import models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserController {
    public List<User> getAll() {
        List<User> products = (List<User>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User").list();
        return products;
    }
    public User getProductId(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }
    public List<User> getName(String name) {
        String hql = "FROM User P WHERE P.Name = :name";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
    public long save(User user) {
        long id = 0;
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            id = (Integer)session.save(user);
            tx1.commit();
            session.close();
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return id;
    }
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
}
