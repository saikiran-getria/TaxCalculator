package com.ria.taxcalculator.service;

import com.ria.taxcalculator.model.Bill;

public class TaxCalculation {
    public static Bill generateBill(Bill bill){
        if ((bill.getItemList()).size() > 0){
            bill.getItemList().forEach(item ->  {
                double tax = 0;
                if (item.isExempted()) {
                } else {
                    tax = (item.getPrice())*(item.getQty()) * 0.1;
                }
                if (item.isImported()) {
                    tax += (item.getPrice())*(item.getQty()) * 0.05;
                }
                //System.out.println(tax);
                tax = (double) Math.round(tax * 20) /20;
                //System.out.println(tax);
                bill.addTotalTax(tax);
                double preTotal= (item.getQty() *item.getPrice());
                item.setPrice(preTotal+tax);
                //item.get(i).setPrice((item.get(i).getQty() *item.get(i).getPrice())+ tax);
                bill.setTotal (bill.getTotal() + item.getPrice());
            });
        }
        return bill;
    }
}
