package com.pranavlari.Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
    Map<String,StockItem> list = new HashMap<>();

    public int addStock(StockItem item) {
        if(item != null)
        {
            StockItem inStock = list.getOrDefault(item.getName().toLowerCase(), item);
            if (inStock != item) {
                item.adjustStock(inStock.getQuantity());
            }
            list.put(item.getName().toLowerCase(), item);
            return item.getQuantity();
        }
        return 0;
    }

    public int sellStock(String item,int qty) {
        StockItem inStock = list.getOrDefault(item.toLowerCase(),null);

        if(inStock != null && inStock.getQuantity() >= qty && qty > 0) {
            inStock.adjustStock(-qty);
            return inStock.getQuantity();
        }
        throw new InvalidStockReqException("Your Stock request is invalid");
    }

    public Map<String, StockItem> getList() {
        return Collections.unmodifiableMap(list);
    }
}
