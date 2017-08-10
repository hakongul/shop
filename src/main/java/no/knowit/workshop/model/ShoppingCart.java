package no.knowit.workshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Shoppingcart", uniqueConstraints = {@UniqueConstraint(columnNames = "SHID")})
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SHID", nullable = false, unique = true, length = 20)
    private int shid;

    @OneToOne()
    @JoinColumn(name = "cid")
    private Customer customer;

    @ManyToMany()
    @JoinColumn(name = "pid")
    private List<Product> products;

    public int getShid() {
        return shid;
    }

    public void setshid(int id) {
        this.shid = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
