package com.pranavlari.Collections;

import java.util.Map;
import java.util.Scanner;

public class ShoppingMain {
    public static void main(String[] args) {
        StockItem bread = new StockItem("Bread",40,100);
        StockItem egg = new StockItem("Eggs",5,150);
        StockItem butter = new StockItem("Butter",50,50);
        StockList breakfastList = new StockList();
        breakfastList.addStock(bread);
        breakfastList.addStock(egg);
        breakfastList.addStock(butter);

        Basket lari = new Basket("Lari");

        Scanner scanner = new Scanner(System.in);
        Map<String,StockItem> items = breakfastList.getList();
        while (true) {
            for(Map.Entry<String,StockItem> item : items.entrySet()) {
                System.out.println(item.getKey()+" Available Quantity:"+ item.getValue().getQuantity());
            }
            System.out.println("Select an item (exit to quit): ");
            String item = scanner.nextLine();
            if(item.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println("Enter Quantity:");
            int qty = scanner.nextInt();
            scanner.nextLine();
            StockItem selectedItem = items.get(item.toLowerCase());
            if(lari.addItem(selectedItem,qty,breakfastList)) {
                System.out.println("Item added");
            }
            System.out.println("Your Basket");
            System.out.println("___________");
            for(Map.Entry<StockItem,Integer> basket : lari.getBasket().entrySet()) {
                System.out.println(basket.getKey().getName()+" "+basket.getValue());
            }

        }
    }
}
