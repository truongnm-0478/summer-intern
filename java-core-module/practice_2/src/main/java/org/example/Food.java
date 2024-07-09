package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Food extends Goods {

    private String mfg;
    private String exp;
    private String supplier;

    public Food(String productCode, String name, int inventoryQuantity, double unitPrice, String mfg, String exp, String supplier) {
        super(productCode, name, inventoryQuantity, unitPrice);
        this.mfg = mfg;
        this.exp = exp;
        this.supplier = supplier;
    }

    public Food() {
        super("", "", 0, 0);
    }

    @Override
    public double calculateVAT() {
        return this.unitPrice * 0.05;
    }

    @Override
    void measureConsumption() {
        if(this.inventoryQuantity >= 0 && isExpired()) {
            System.out.println("Food item " + this.name + " is hard to sell.");
        } else {
            System.out.println("Food item " + this.name + " is not evaluated.");
        }
    }

    @Override
    public void inputProductInfo(Scanner scanner) {
        super.inputProductInfo(scanner);
        System.out.print("Enter manufacture date (yyyy-MM-dd): ");
        mfg = scanner.nextLine();
        System.out.print("Enter expiration date (yyyy-MM-dd): ");
        exp = scanner.nextLine();
        System.out.print("Enter supplier: ");
        supplier = scanner.nextLine();
    }

    public boolean isExpired() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date exp = dateFormat.parse(this.exp);
            Date currentDate = new Date();
            return currentDate.after(exp);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
