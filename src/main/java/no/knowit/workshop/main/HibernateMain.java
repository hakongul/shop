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

        Customer cust = HM.addCustomer("Kunde", "Kundesen", "Ku", "kunde.kundesen@kundesen.net");
        cust.setNickname("KuKu");
        Customer changedCustomer = (Customer)HM.updateObject(cust);
        System.out.println("Customer ID: " + changedCustomer.getId() + " with nickname: " + changedCustomer.getNickname());

        Product prod = HM.addProduct("Melk", 10, "Billigste melka!");
        prod.setDescription("Den beste OG BILLIGSTE melka!");
        Product changedProduct = (Product)HM.updateObject(prod);
        System.out.println("Product ID: " + changedProduct.getId() + " with description: " + changedProduct.getDescription());

        System.exit(1);
    }

    private Customer addCustomer(String firstname, String lastname, String nickname, String email) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstname(firstname);
        newCustomer.setLastname(lastname);
        newCustomer.setNickname(nickname);
        newCustomer.setEmail(email);
        newCustomer.setRegistrationDate(new Date());

        Customer saved = (Customer)saveObject(newCustomer);

        System.out.println("New Customer ID: " + saved.getId() + " with name: " + saved.getFirstname() + " " +
                saved.getLastname() + " and nickname: " + saved.getNickname());

        return saved;
    }

    private Product addProduct(String productname, int price, String description) {
        Product newProduct = new Product();
        newProduct.setProductName(productname);
        newProduct.setPrice(price);
        newProduct.setDescription(description);

        Product saved = (Product)saveObject(newProduct);

        System.out.println("New Product ID: " + saved.getId() + " with name: " + saved.getProductName() +
                " and description: " + saved.getDescription());

        return saved;
    }

    private Object saveObject(Object object) {
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();

        return object;
    }

    private Object updateObject(Object object) {

        SessionFactory sf = HibernateUtil.getSessionAnnotationFactory();
        Session s = sf.getCurrentSession();

        s.beginTransaction();
        s.update(object);
        s.getTransaction().commit();
        s.close();

        return object;
    }
}
