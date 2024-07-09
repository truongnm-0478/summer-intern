package model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="partner_id")
    private Person partner;

    public Person() {
    }

    public Person(String name, Date dateOfBirth, Person partner) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.partner = partner;
    }

    public Person(long id, String name, Date dateOfBirth, Person partner) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.partner = partner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }
}
