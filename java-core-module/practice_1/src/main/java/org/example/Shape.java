package org.example;

public class Shape {
    protected double width;
    protected double height;

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void display() {
        display("shape");
    }

    public void display(String name) {
        System.out.println("Information of " + name + ":\nWidth = " + this.width + " Height = " + this.height + ";");
    }
}

