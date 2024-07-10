package model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private Date date;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "meeting_employee",
            joinColumns = {@JoinColumn(name = "meeting_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private Set<Employee> employees = new HashSet<Employee>();

    public Meeting() {
    }

    public Meeting(int id, String name, String location, Date date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }
}
