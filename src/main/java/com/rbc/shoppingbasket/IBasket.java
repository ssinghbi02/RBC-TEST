package com.rbc.shoppingbasket;

import java.math.BigDecimal;

/**
 * Interface for Basket.
 */
public interface IBasket {

    /**
     * @param itemID          item id
     * @param itemName        item name
     * @param itemPrice       item price
     * @param itemDescription description
     * @param itemQuantity    quantity
     */
    void add(final Integer itemID, final String itemName, final BigDecimal itemPrice, final String itemDescription, final Integer itemQuantity);

    /**
     * @param itemName item name
     */
    void remove(final String itemName);
}
