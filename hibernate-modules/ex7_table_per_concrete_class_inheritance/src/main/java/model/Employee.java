package model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
public class Employee extends Person {
    private String department;

    public Employee(String department) {
        this.department = department;
    }

    public Employee(long id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public Employee() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
