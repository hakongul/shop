package no.knowit.workshop.main;

import no.knowit.workshop.model.Customer;
import no.knowit.workshop.model.Product;
import no.knowit.workshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class HibernateMain {
    public static void main(String[] args) {
        HibernateMain HM = new HibernateMain();

        HM.addCustomer("Kunde", "Kundesen", "Ku", "kunde.kundesen@kundesen.net");

        HM.addProduct("Melk", 10, "Billigste melka!");
    }

    public void addCustomer(String firstname, String lastname, String nickname, String email) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstname(firstname);
        newCustomer.setLastname(lastname);
        newCustomer.setNickname(nickname);
        newCustomer.setEmail(email);
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

    public void addProduct(String productname, int price, String description) {
        Product newProduct = new Product();
        newProduct.setProductName(productname);
        newProduct.setPrice(price);
        newProduct.setDescription(description);

        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        session.save(newProduct);

        session.getTransaction().commit();

        System.out.println("New Product ID: " + newProduct.getId() + " with name: " + newProduct.getProductName());

        session.close();
        System.exit(1);
    }
}
