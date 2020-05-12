package com.pranavlari.Collections;

import java.util.Objects;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantity = 0;

    public StockItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void adjustStock(int quantity) {
        int newQty = this.quantity + quantity;
        if(newQty >= 0) {
            setQuantity(newQty);
        }

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockItem stockItem = (StockItem) o;
        return name.equals(stockItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name:"+ this.name+" Price:"+this.price+" Quantity:"+this.quantity;
    }

    @Override
    public int compareTo(StockItem o) {
        if(o == this) {
            return 0;
        }
        else if(o != null) {
            return this.name.compareToIgnoreCase(o.getName());
        }
        throw new NullPointerException();
    }
}
