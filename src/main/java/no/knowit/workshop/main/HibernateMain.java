package no.knowit.workshop.main;

import no.knowit.workshop.model.Customer;
import no.knowit.workshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class HibernateMain {
    public static void main(String[] args) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstname("Kunde");
        newCustomer.setLastname("Kundesen");
        newCustomer.setEmail("kunde.kundesen@kundesen.net");
        newCustomer.setRegistrationDate(new Date());

        //Get session
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
        //Start transaction
        session.beginTransaction();
        //Save the object
        session.save(newCustomer);
        //Commit transaction
        session.getTransaction().commit();

        System.out.println("Customer ID: " + newCustomer.getId());

        //Kill it
        session.close();
    }
}
