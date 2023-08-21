package com.ria.taxcalculator;

import com.ria.taxcalculator.model.Bill;
import com.ria.taxcalculator.model.Item;
import com.ria.taxcalculator.service.TaxCalculation;

import java.util.*;


public class Main {
    public static boolean containsItems(String line, String[] exemptedItems) {
        int pos = -1;
        for (int i = 0; i < exemptedItems.length; i++) {

            if (line.contains(exemptedItems[i]))
                return true;

        }

        return false;

    }


    public static void main(String[] args) {
        Bill bill = new Bill();
        Scanner input = new Scanner(System.in);
        //try {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                List<String> words = Arrays.asList(line.split(" "));
                if (words.contains(""))
                    break;
                Item item1 = new Item();
                item1.setQty(Integer.parseInt(words.get(0)));
                item1.setImported(line.contains("imported"));
                String[] exemptedItems = new String[]{"book", "chocolates", "pills"};
                item1.setExempted(containsItems(line, exemptedItems));
                //System.out.println(item1.isExempted());
                int priceIndex = line.lastIndexOf("at");
                if (priceIndex == -1) {
                    System.out.println("entered incorrectly");
                }
                else {

                    item1.setPrice(Double.parseDouble(line.substring(priceIndex + 2)));
                    item1.setName(line.substring(1, priceIndex));
                }
                bill.addItem(item1);

            }
        //}catch (Exception ignored) {

        //}
        //TaxCalculation calculate = new TaxCalculation();
        TaxCalculation.generateBill(bill);
        bill.receipt();

    }
}