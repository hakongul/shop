package no.knowit.workshop.main;

import no.knowit.workshop.model.Customer;
import no.knowit.workshop.model.Product;
import no.knowit.workshop.model.ShoppingCart;
import no.knowit.workshop.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Runner {
    void run(){
        Customer cust = addCustomer("Kunde", "Kundesen", "Ku", "kunde.kundesen@kundesen.net");
        cust.setNickname("KuKu");
        Customer changedCustomer = (Customer)updateObject(cust);
        System.out.println("Customer ID: " + changedCustomer.getCid() + " with nickname: " + changedCustomer.getNickname());

        Product prod = addProduct("Melk", 10, "Billigste melka!");
        prod.setDescription("Den beste OG BILLIGSTE melka!");
        Product changedProduct1 = (Product)updateObject(prod);
        System.out.println("Product ID: " + changedProduct1.getPid() + " with description: " + changedProduct1.getDescription());

        Product prod2 = addProduct("Brød", 10, "Billigste brødet!");
        prod2.setDescription("Det beste OG BILLIGSTE brødet!");
        Product changedProduct2 = (Product)updateObject(prod2);
        System.out.println("Product ID: " + changedProduct2.getPid() + " with description: " + changedProduct2.getDescription());

        List<Product> prods = Arrays.asList(changedProduct1, changedProduct2);
        addCart(changedCustomer, prods);

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

        System.out.println("New Customer ID: " + saved.getCid() + " with name: " + saved.getFirstname() + " " +
                saved.getLastname() + " and nickname: " + saved.getNickname());

        return saved;
    }

    private Product addProduct(String productname, int price, String description) {
        Product newProduct = new Product();
        newProduct.setProductName(productname);
        newProduct.setPrice(price);
        newProduct.setDescription(description);

        Product saved = (Product)saveObject(newProduct);

        System.out.println("New Product ID: " + saved.getPid() + " with name: " + saved.getProductName() +
                " and description: " + saved.getDescription());

        return saved;
    }

    private ShoppingCart addCart(Customer c, List<Product> prods){
        ShoppingCart cart = new ShoppingCart();
        cart.setCustomer(c);
        cart.setProducts(prods);

        ShoppingCart saved = (ShoppingCart)saveObject(cart);

        System.out.println("Shopping cart ID: " + saved.getShid() + " for customer ID: " + saved.getCustomer().getCid() +
                " and products: " + saved.getProducts().get(0).getProductName() + ", " + saved.getProducts().get(1).getProductName());

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
