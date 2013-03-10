package com.envers;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.hibernate.ejb.EntityManagerImpl;
import org.hibernate.internal.SessionImpl;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

public class App 
{
    public static void main( String[] args )
    {
       
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Book.class)
                                                           .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver") 
                                                           .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/library")
                                                           .setProperty("hibernate.connection.username", "postgres")
                                                           .setProperty("hibernate.connection.password", "postgres")
                                                           .setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect")
                                                           .setProperty("hibernate.show_sql", "true")
                                                           .setProperty("create", "true")
                                                          // .setProperty("post-update","org.hibernate.envers.event.EnversPostUpdateEventListenerImpl")
                                                         //  .setProperty("pre-update","org.hibernate.envers.event.EnversPostUpdateEventListenerImpl")
                                                           .setProperty("hbm2dll.auto", "update")
                                                           .buildSessionFactory();
     
      /* Configuration conf = new Configuration().addAnnotatedClass(Book.class)
                                                           .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver") 
                                                           .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/library")
                                                           .setProperty("hibernate.connection.username", "postgres")
                                                           .setProperty("hibernate.connection.password", "postgres")
                                                           .setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect")
                                                           .setProperty("hibernate.show_sql", "true")
                                                           .setProperty("create", "true")
                                                           .setProperty("post-update","org.hibernate.envers.event.EnversPostUpdateEventListenerImpl")
                                                           .setProperty("hbm2dll.auto", "update");
                         
        */
        Book book = new Book("book 1", 1234);

   //     EntityManager manager = new EntityManagerImpl();
        
     
     
        Session session = sessionFactory.openSession();
    
        Transaction tx =  session.beginTransaction();
        
        session.saveOrUpdate(book);
        book.setIsin(99);
        tx.commit();
        
        session.close();    
        
       // org.hibernate.envers.event.EnversPostUpdateEventListenerImpl
        
        System.out.println( "Hello World!" );
    }
}
