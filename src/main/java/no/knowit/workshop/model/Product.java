package no.knowit.workshop.model;

import javax.persistence.*;

@Entity
@Table(name = "Product", uniqueConstraints = {@UniqueConstraint(columnNames = "ID")})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 20)
    private int id;

    @Column(name = "PRODUCTNAME", nullable = false)
    private String productName;

    @Column(name = "PRICE", nullable = false)
    private int price;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getProductName() { return productName; }

    public void setProductName(String productName) { this.productName = productName; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
