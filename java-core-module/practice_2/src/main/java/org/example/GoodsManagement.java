package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodsManagement {
    private List<Goods> listGoods;

    public GoodsManagement () {
        this.listGoods = new ArrayList<>();
    }

    public void addGoods(Goods goods) {
        for(Goods g : listGoods) {
            if(g.productCode.equals(goods.productCode)) {
                System.out.println("Duplicate product code!");
                return;
            }
        }
        listGoods.add(goods);
        System.out.println("Goods added successfully!");
    }

    public void addGoodsOfType(int type) {
        Scanner scanner = new Scanner(System.in);
        switch (type) {
            case 1:
                addFood(scanner);
                break;
            case 2:
                addElectronics(scanner);
                break;
            case 3:
                addCrockery(scanner);
                break;
            default:
                System.out.println("Invalid type.");
        }
    }

    private void addFood(Scanner scanner) {
        Food food = new Food();
        food.inputProductInfo(scanner);
        addGoods(food);
    }

    private void addElectronics(Scanner scanner) {
        Electronics electronics = new Electronics();
        electronics.inputProductInfo(scanner);
        addGoods(electronics);
    }

    private void addCrockery(Scanner scanner) {
        Crockery crockery = new Crockery();
        crockery.inputProductInfo(scanner);
        addGoods(crockery);
    }

    public void displayListGoods() {
        for (Goods goods : listGoods) {

            System.out.println("---------------------------------------------");
            System.out.println(goods.name + " - Inventory Quantity: " + goods.inventoryQuantity);
            goods.measureConsumption();
            System.out.println("---------------------------------------------");
        }
    }



}
