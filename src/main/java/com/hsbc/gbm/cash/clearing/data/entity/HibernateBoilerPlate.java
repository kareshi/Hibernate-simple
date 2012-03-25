package com.hsbc.gbm.cash.clearing.data.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateBoilerPlate {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

    public static void main(String[] args) {
        System.out.println("Ivan");
        Session session = getSessionFactory().openSession();

        session.beginTransaction();
        User user = new User();

        user.setName("Ivan");
        user.setPassword("Chio");

        session.save(user);
        session.getTransaction().commit();


    }

}
