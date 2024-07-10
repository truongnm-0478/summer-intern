package model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.*;

@Entity
public class Employee {

    @Id
    private String id;
    private String name;
    private Date dateOfBirth;

    @ManyToMany(mappedBy = "employees")
    private Set<Meeting> meetings = new HashSet<Meeting>();

    public Employee() {
    }

    public Employee(String id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
