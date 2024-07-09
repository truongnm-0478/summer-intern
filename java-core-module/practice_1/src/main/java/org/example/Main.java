package org.example;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Shape(10, 20);
        shape.display();

        Rectangle rectangle = new Rectangle(20, 30);
        rectangle.display("rectangle");

        Circle circle = new Circle(27);
        circle.display("circle");

    }
}