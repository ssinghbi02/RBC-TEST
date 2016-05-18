package com.rbc.shoppingbasket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class Basket implements IBasket {
    private Integer itemCount;
    private BigDecimal totalPrice;
    private Integer capacity;
    private List<Item> cart;

    public Basket(final Integer capacity) {
        this.capacity = capacity;
        this.cart = new ArrayList<Item>();
    }

    public void add(final Integer itemID, final String itemName, final BigDecimal itemPrice, final String itemDescription, final Integer itemQuantity) {
        Item item = new Item(itemID, itemName, itemPrice, itemDescription, itemQuantity);
        totalPrice.add(itemPrice.multiply(new BigDecimal(itemQuantity)));
        cart.add(item);
        itemCount += 1;
    }

    public void remove(final String itemName) {
        this.cart = new ArrayList<Item>();
        for (Item item : cart) {
            if (itemName.equals(item.getName())) {
                cart.remove(item);
            }
        }
    }

    public BigDecimal calculateCost() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Item item : cart) {
            totalPrice.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return totalPrice;
    }
}
