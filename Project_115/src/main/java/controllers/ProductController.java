package controllers;

import models.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ProductController {
    public List<Product> getAll() {
        List<Product> products = (List<Product>)HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return products;
    }
    public Product getProductId(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }
    public List<Product> getName(String name) {
        String hql = "FROM Product P WHERE P.Name = :name";
        Query query = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }
    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }
}
