package com.ria.taxcalculator.service;


import com.ria.taxcalculator.model.Bill;
import com.ria.taxcalculator.model.Item;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TaxCalculationTest {

    @Test(expected = NullPointerException.class)
    public void testGenerateBill_EmptyBill() {
        TaxCalculation.generateBill(new Bill());
    }

    @Test
    public void testGenerateBill_ForExemptedItem() {
        Item item = new Item();
        item.setExempted(true);
        item.setImported(true);
        item.setName("Butter");
        item.setPrice(10.0);
        item.setQty(1);
        Bill bill = new Bill();
        bill.addItem(item);
        Bill actualGenerateBillResult = TaxCalculation.generateBill(bill);
        assertEquals(0.5, actualGenerateBillResult.getTotalTax(), 0.0);
        assertEquals(10.5, actualGenerateBillResult.getTotal(), 0.0);
        assertEquals(10.5, actualGenerateBillResult.getItemList().get(0).getPrice(), 0.0);
    }


    @Test
    public void testGenerateBill_ForAllCases() {
        Item item1 = new Item();
        item1.setExempted(true);
        item1.setImported(true);
        item1.setName("Butter");
        item1.setPrice(10.0);
        item1.setQty(1);

        Item item2 = new Item();
        item2.setExempted(false);
        item2.setImported(false);
        item2.setName("42");
        item2.setPrice(20.0);
        item2.setQty(3);

        Item item3 = new Item();
        item3.setExempted(true);
        item3.setImported(false);
        item3.setName("42");
        item3.setPrice(20.0);
        item3.setQty(3);

        Item item4 = new Item();
        item4.setExempted(false);
        item4.setImported(true);
        item4.setName("42");
        item4.setPrice(20.0);
        item4.setQty(3);

        Bill bill = new Bill();
        bill.addItem(item1);
        bill.addItem(item2);
        bill.addItem(item3);
        bill.addItem(item4);
        Bill actualGenerateBillResult = TaxCalculation.generateBill(bill);
        assertEquals(15.5, actualGenerateBillResult.getTotalTax(), 0.0);
        assertEquals(205.5, actualGenerateBillResult.getTotal(), 0.0);
        List<Item> itemList = actualGenerateBillResult.getItemList();
        assertEquals(66.0, itemList.get(1).getPrice(), 0.0);
        assertEquals(10.5, itemList.get(0).getPrice(), 0.0);
    }

    @Test(expected = NullPointerException.class)
    public void testGenerateBill_ForNullBill() {
        TaxCalculation.generateBill(null);
    }

}

