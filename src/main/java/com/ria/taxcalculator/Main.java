package com.ria.taxcalculator;

import com.ria.taxcalculator.model.Bill;
import com.ria.taxcalculator.model.InputScanner;
import com.ria.taxcalculator.service.TaxCalculation;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Bill bill = new Bill();
        InputScanner input1 = new InputScanner();
        Scanner input = new Scanner(System.in);
        input1.inputScanner(input);
        TaxCalculation.generateBill(bill);
        bill.receipt();

    }
}