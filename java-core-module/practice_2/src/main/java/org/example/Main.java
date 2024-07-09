package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GoodsManagement goodsManagement = new GoodsManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=============================================");
            System.out.println("Choose type:");
            System.out.println("1. Add food");
            System.out.println("2. Add electronics");
            System.out.println("3. Add crockery");
            System.out.println("4. Inventory");
            System.out.println("5. Exit");
            System.out.println("=============================================");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) {
                break;
            }

            if (choice == 4) {
                System.out.println("Inventory: ");
                goodsManagement.displayListGoods();
                continue;
            }

            goodsManagement.addGoodsOfType(choice);

        }

        System.out.println("Inventory:");
        goodsManagement.displayListGoods();
    }
}