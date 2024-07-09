package org.example;

public class Car extends Vehicle {
    private int numberOfSeats;
    private String engineType;

    public Car(String vehicleNumber, String manufacturer, int yearOfManufacture, String color, Owner owner, int numberOfSeats, String engineType) {
        super(vehicleNumber, manufacturer, yearOfManufacture, color, owner);
        this.numberOfSeats = numberOfSeats;
        this.engineType = engineType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}