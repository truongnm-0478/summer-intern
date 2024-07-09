package org.example;

import java.util.Scanner;

abstract class Goods {
    String productCode;
    String name;
    int inventoryQuantity;
    double unitPrice;

    public Goods(String productCode, String name, int inventoryQuantity, double unitPrice) {
        this.productCode = productCode;
        this.name = name;
        this.inventoryQuantity = inventoryQuantity;
        this.unitPrice = unitPrice;
    }

    abstract double calculateVAT();

    abstract void measureConsumption();

    public void inputProductInfo(Scanner scanner) {
        System.out.print("Enter product code: ");
        productCode = scanner.nextLine();
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter inventory quantity: ");
        inventoryQuantity = scanner.nextInt();
        System.out.print("Enter unit price: ");
        unitPrice = scanner.nextDouble();
        scanner.nextLine();
    }

}
