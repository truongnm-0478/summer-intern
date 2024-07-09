package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Crockery extends Goods {

    private String manufacturer;
    private String arrivalDate;

    public Crockery(String productCode, String name, int inventoryQuantity, double unitPrice, String manufacturer, String arrivalDate) {
        super(productCode, name, inventoryQuantity, unitPrice);
        this.manufacturer = manufacturer;
        this.arrivalDate = arrivalDate;
    }

    public Crockery() {
        super("", "", 0, 0);
    }

    @Override
    double calculateVAT() {
        return this.unitPrice * 0.1;
    }

    @Override
    void measureConsumption() {
        if(this.inventoryQuantity > 50 && storageTimeMoreThan10Days()) {
            System.out.println("Crockery item " + this.name + " is slow to sell.");
        }
        else {
            System.out.println("Crockery item " + this.name + " is not evaluated.");
        }
    }

    @Override
    public void inputProductInfo(Scanner scanner) {
        super.inputProductInfo(scanner);
        System.out.print("Enter manufacturer: ");
        manufacturer = scanner.nextLine();
        System.out.print("Enter arrival date (yyyy-MM-dd): ");
        arrivalDate = scanner.nextLine();
    }

    public boolean storageTimeMoreThan10Days() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date arrivalDate = dateFormat.parse(this.arrivalDate);
            Date currentDate = new Date();
            long differenceInMillis = currentDate.getTime() - arrivalDate.getTime();
            long differenceInDays = differenceInMillis / (1000 * 60 * 60 * 24);
            return differenceInDays > 10;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
