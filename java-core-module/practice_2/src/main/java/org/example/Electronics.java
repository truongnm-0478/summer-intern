package org.example;

import java.util.Scanner;

public class Electronics extends Goods {

    private int warrantyMonths;
    private double capacityKW;

    public Electronics(String productCode, String name, int inventoryQuantity, double unitPrice, int warrantyMonths, double capacityKW) {
        super(productCode, name, inventoryQuantity, unitPrice);
        this.warrantyMonths = warrantyMonths;
        this.capacityKW = capacityKW;
    }

    public Electronics() {
        super("", "", 0, 0);
    }

    @Override
    double calculateVAT() {
        return this.unitPrice * 0.1;
    }

    @Override
    void measureConsumption() {
        if(this.inventoryQuantity < 3) {
            System.out.println("Electronic item " + this.name + " is considered to be sold.");
        } else {
            System.out.println("Electronic item " + this.name + " is not evaluated.");
        }
    }

    @Override
    public void inputProductInfo(Scanner scanner) {
        super.inputProductInfo(scanner);
        System.out.print("Enter warranty months: ");
        warrantyMonths = scanner.nextInt();
        System.out.print("Enter capacity KW: ");
        capacityKW = scanner.nextDouble();
        scanner.nextLine();
    }
}
