package com.cognizant.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        Student s = new Student("A","sai","sai@gmail.com");

        session.save(s);

        tx.commit();
    }
}
