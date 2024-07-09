package org.example;

public class Truck extends Vehicle {
    private int tonnage;

    public Truck(String vehicleNumber, String manufacturer, int yearOfManufacture, String color, Owner owner, int tonnage) {
        super(vehicleNumber, manufacturer, yearOfManufacture, color, owner);
        this.tonnage = tonnage;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }
}
