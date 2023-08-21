package com.ria.taxcalculator.model;

import java.util.List;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class InputScannerTest {
    @Test(expected = NumberFormatException.class)
    public void test_NumberFormatException() {
        InputScanner input = new InputScanner();
        input.inputScanner(new Scanner("Line"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_ArrayIndexOutOfBoundsException() {
        InputScanner input = new InputScanner();
        input.inputScanner(new Scanner(" "));
    }

    @Test
    public void testI_EmptyInput() {
        Bill bill = new Bill();
        InputScanner input = new InputScanner();
        input.inputScanner(new Scanner(""));
        assertEquals(0.0, bill.getTotalTax(), 0.0);
        assertEquals(0.0, bill.getTotal(), 0.0);
//        System.out.println(bill.getTotal());
//        System.out.println(bill.getTotalTax());

    }

    @Test
    public void test_ToReturn_onlyqty() {
        Bill bill = new Bill();
        InputScanner input = new InputScanner();
        List<Item> itemList = (input.inputScanner(new Scanner("42"))).getItemList();
        assertEquals(1, itemList.size());
        Item getResult = itemList.get(0);
        assertFalse(getResult.isImported());
        assertFalse(getResult.isExempted());
        assertEquals(42, getResult.getQty());
    }


    @Test(expected = NullPointerException.class)
    public void test_NullPointerException() {
        InputScanner input = new InputScanner();
        (new InputScanner()).inputScanner(null);
    }

    @Test
    public void test_BooleanConditions() {
        Item item = new Item();
        item.setExempted(false);
        item.setImported(false);
        item.setName(" ");
        item.setPrice(10.0);
        item.setQty(1);
        Bill bill = new Bill();
        //InputScanner input = new InputScanner();
        bill.addItem(item);
        List<Item> itemList = bill.getItemList();
        assertEquals(1, itemList.size());
        Item getResult = itemList.get(0);
        assertFalse(getResult.isImported());
        assertFalse(getResult.isExempted());
        assertEquals(1, getResult.getQty());
    }

    @Test
    public void test_WrongInput() {
        Bill bill = new Bill();
        InputScanner input = new InputScanner();
        input.inputScanner(new Scanner(" Line"));
        assertEquals(0.0, bill.getTotalTax(), 0.0);
        assertEquals(0.0, bill.getTotal(), 0.0);
    }

    @Test
    public void test_RightInput() {
        Bill bill = new Bill();
        InputScanner input = new InputScanner();
        List<Item> itemList = (input.inputScanner(new Scanner("1 book at 12.49"))).getItemList();
        assertEquals(1, itemList.size());
        Item getResult = itemList.get(0);
        assertFalse(getResult.isImported());
        assertTrue(getResult.isExempted());
        assertEquals(12.49, getResult.getPrice(), 0.0);
    }




    @Test
    public void testContainsItems() {
        assertFalse(InputScanner.containsItems("Line", new String[]{"Exempted Items"}));
        assertTrue(InputScanner.containsItems("Line", new String[]{"Line"}));
        assertTrue(InputScanner.containsItems("Items", new String[]{"Items"}));
    }
}