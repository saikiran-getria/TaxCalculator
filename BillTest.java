package com.ria.taxcalculator.model;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class BillTest {

    @Test
    public void testAddItem() {
        Bill bill = new Bill();
        Item item = new Item();
        InputScanner input = new InputScanner();
        item.setExempted(true);
        item.setImported(true);
        item.setName("Butter");
        item.setPrice(10.0);
        item.setQty(1);
        bill.addItem(item);
        assertEquals(1, bill.getItemList().size());
        //assertEquals(1, bill.listSize());
        //System.out.println(bill.getItemList().size());
    }


    @Test(expected = NullPointerException.class)
    public void testListSize_NullPointerException() {
        (new Bill()).getItemList().size();
    }


    @Test
    public void testReceipt() {
        Item item = new Item();
        item.setExempted(true);
        item.setImported(true);
        item.setName("Biscuit");
        item.setPrice(15.0);
        item.setQty(1);

        Item item2 = new Item();
        item2.setExempted(true);
        item2.setImported(true);
        item2.setName("Rice");
        item2.setPrice(20.0);
        item2.setQty(2);

        Item item3 = new Item();
        item3.setExempted(true);
        item3.setImported(true);
        item3.setName("Butter");
        item3.setPrice(10.0);
        item3.setQty(3);

        Item item4 = new Item();
        item4.setExempted(true);
        item4.setImported(true);
        item4.setName("Bread");
        item4.setPrice(5.0);
        item4.setQty(4);

        Item item5 = new Item();
        item5.setExempted(true);
        item5.setImported(true);
        item5.setName("Oil");
        item5.setPrice(30.0);
        item5.setQty(5);

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        Bill bill = new Bill();
        bill.setItemList(itemList);
        bill.receipt();
    }

    @Test
    public void testConstructor() {
        Bill bill = new Bill();
        ArrayList<Item> itemList = new ArrayList<>();
        bill.setItemList(itemList);
        bill.setTotal(10.0);
        bill.setTotalTax(10.0);
        assertEquals(10.0, bill.addTotalTax(10.0), 0.0);
        assertSame(itemList, bill.getItemList());
        assertEquals(10.0, bill.getTotal(), 0.0);
        assertEquals(20.0, bill.getTotalTax(), 0.0);
    }
}

