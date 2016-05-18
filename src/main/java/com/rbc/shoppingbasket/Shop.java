package com.rbc.shoppingbasket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ssinghbi02 on 17/05/2016.
 */
public class Shop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> cart = new ArrayList<Item>();

        Item item;
        int itemID;
        String itemName;
        double itemPrice;
        String itemDescription;
        int itemQuantity;
        double itemTax;
        int ch;
        String choice;

        Basket basket = new Basket(10);

        while (true) {
            System.out.println("Menu:");
            System.out.println("0) Exit " + "\n"
                    + "1) Add item in shopping cart" + "\n"
                    + "2) Remove item from shpping cart");
            ch = sc.nextInt();

            switch (ch) {
                case 0:
                    System.out.println("\n" + "Good bye!");
                    System.exit(0);

                case 1:
                    System.out.println("Enter item ID: ");
                    itemID = sc.nextInt();

                    System.out.println("Enter item name: ");
                    itemName = sc.next();

                    System.out.println("Enter item price: ");
                    itemPrice = sc.nextDouble();

                    System.out.println("Enter short description of item: ");
                    itemDescription = sc.next();

                    System.out.println("Enter quantity: ");
                    itemQuantity = sc.nextInt();

                    System.out.println("Enter tax rate:");
                    itemTax = sc.nextDouble();


                    basket.add(itemID, itemName, new BigDecimal(itemPrice), itemDescription, itemQuantity);

                    break;

                case 2:
                    System.out.println("Enter name of the item that you would like to remove: ");
                    choice = sc.next();
                    basket.remove(choice);
                    break;
            }

        }
    }

}