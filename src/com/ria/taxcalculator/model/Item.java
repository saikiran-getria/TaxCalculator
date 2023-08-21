package com.ria.taxcalculator.model;

public class Item {
    private String name;
    private double price;
    private int qty;
    private boolean isExempted;
    private boolean isImported;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isExempted() {
        return isExempted;
    }

    public void setExempted(boolean exempted) {
        isExempted = exempted;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
