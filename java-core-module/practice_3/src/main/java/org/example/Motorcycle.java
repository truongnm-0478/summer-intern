package org.example;

public class Motorcycle extends Vehicle {
    private int capacity;

    public Motorcycle(String vehicleNumber, String manufacturer, int yearOfManufacture, String color, Owner owner, int capacity) {
        super(vehicleNumber, manufacturer, yearOfManufacture, color, owner);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
