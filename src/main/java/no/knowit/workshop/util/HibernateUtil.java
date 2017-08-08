package no.knowit.workshop.util;

import no.knowit.workshop.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionAnnotationFactory;

    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Annotation Config loaded");

            ServiceRegistry serviceRegistry = new
                    StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
            System.out.println("Hibernate Annotation serviceRegistry created");

            return config.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex){
            System.err.println("Initial SessionFactory creation went to hell: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionAnnotationFactory() {
        if(sessionAnnotationFactory == null) sessionAnnotationFactory = buildSessionAnnotationFactory();
        return sessionAnnotationFactory;
    }
}
