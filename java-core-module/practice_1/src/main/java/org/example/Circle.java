package org.example;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super(radius, 0);
        this.radius = radius;
    }

    public double getArea() {
        return Math.round(Math.PI * radius * radius * 100.0) / 100.0;
    }

    public double getCircumference() {
        return Math.round(2 * Math.PI * radius * 100.0) / 100.0;
    }

    @Override
    public void display(String name) {
        System.out.println("Information of " + name + ":\nRadius = " + this.radius + ";");
        System.out.println("Area = " + getArea() + " Circumference = " + getCircumference() + ";");
    }
}

