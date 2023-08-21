<<<<<<< HEAD:src/com/ria/taxcalculator/model/InputScanner.java
package com.ria.taxcalculator.model;public class InputScanner {
=======
package com.ria.taxcalculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputScanner {
    public Bill inputScanner(Scanner input) {
        Bill bill = new Bill();
        try{
            while (input.hasNextLine()) {
                String line = input.nextLine();
                List<String> words = Arrays.asList(line.split(" "));
                if (words.contains(""))
                    break;
                Item item1 = new Item();
                item1.setQty(Integer.parseInt(words.get(0)));
                //item1.setQty(Integer.parseInt(words.get(0)));
                item1.setImported(line.contains("imported"));
                String[] exemptedItems = new String[]{"book", "chocolate", "pills"};
                item1.setExempted(containsItems(line, exemptedItems));
                //System.out.println(item1.isExempted());
                int priceIndex = line.lastIndexOf("at");
                if (priceIndex == -1) {
                    System.out.println("entered incorrectly");
                } else {

                    item1.setPrice(Double.parseDouble(line.substring(priceIndex + 2)));
                    item1.setName(line.substring(1, priceIndex));
                }
                bill.addItem(item1);
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        } catch (ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException();
        }catch (NullPointerException e){
            throw new NullPointerException();
        }
        return bill;
    }

    public static boolean containsItems(String line, String[] exemptedItems) {
        for (int i = 0; i < exemptedItems.length; i++) {

            if (line.contains(exemptedItems[i]))
                return true;

        }

        return false;

    }
>>>>>>> parent of 2cdf643 (new commit):src/main/java/com/ria/taxcalculator/model/InputScanner.java
}
