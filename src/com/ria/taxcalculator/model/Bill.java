package com.ria.taxcalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private List<Item> itemList;
    private double totalTax;
    private double total;
    public void addItem(Item item) {
        if (itemList == null) {
            itemList = new ArrayList<>();
        }
        itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int listSize(){
        return itemList.size();
    }
    public double addTotalTax(double tax){
        totalTax +=tax;
        return tax;
    }
    public void receipt(){

        int size = listSize();
        for(int i = 0;i<size;i++){
            System.out.printf(getItemList().get(i).getQty() +" "+ getItemList().get(i).getName() + ":"+"%.2f\n",getItemList().get(i).getPrice());
        }
        System.out.printf("Sales Tax: %.2f\n", totalTax);
        System.out.printf("Total: %.2f\n", + this.total);

    }





}
