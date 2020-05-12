package com.pranavlari.Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private String userName;
    private Map<StockItem,Integer> basket = new TreeMap<>();
    private double totalVal= 0;

    public Basket(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Map<StockItem, Integer> getBasket() {
        return Collections.unmodifiableMap(basket);
    }

    public double getTotalVal() {
        return totalVal;
    }

    public boolean addItem(StockItem item, int qty, StockList list) {
        if(item != null && qty > 0) {
            try {
                list.sellStock(item.getName(),qty);
                int currentBasketItem = basket.getOrDefault(item,0);
                basket.put(item,currentBasketItem + qty);
                this.totalVal = item.getPrice() * currentBasketItem + qty;
                return true;
            }
            catch (InvalidStockReqException e) {
                System.out.println(item.getName()+" Don't have enough qty");
                return false;
            }
        }
        System.out.println("Select a valid item and quantity");
        return false;
    }


}
