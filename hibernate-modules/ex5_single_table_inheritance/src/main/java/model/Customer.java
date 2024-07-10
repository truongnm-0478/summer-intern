package model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Customer")
public class Customer extends Person {
    private String customerType;

    public Customer(String customerType) {
        this.customerType = customerType;
    }

    public Customer(long id, String name, String customerType) {
        super(id, name);
        this.customerType = customerType;
    }

    public Customer() {
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
