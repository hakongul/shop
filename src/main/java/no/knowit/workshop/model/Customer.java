package no.knowit.workshop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Customer", uniqueConstraints = {@UniqueConstraint(columnNames = "CID")})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CID", nullable = false, unique = true, length = 20)
    private int cid;

    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    @Column(name = "NICKNAME", nullable = true)
    private String nickname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "REG_DATE", nullable = false)
    private Date registrationDate;

    public int getCid() {
        return cid;
    }

    public void setCid(int id) {
        this.cid = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
