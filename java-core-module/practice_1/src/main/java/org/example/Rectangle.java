package org.example;

public class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    public double getArea() {
        return Math.round(width * height * 100.0) / 100.0;
    }

    public double getPerimeter() {
        return Math.round(2 * (width + height) * 100.0) / 100.0;
    }

    @Override
    public void display(String name) {
        super.display(name);
        System.out.println("Area = " + getArea() + " Perimeter = " + getPerimeter() + ";");
    }
}


