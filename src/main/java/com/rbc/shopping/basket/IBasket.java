package com.rbc.shopping.basket;

import com.rbc.shopping.item.IGenericItem;

import java.math.BigDecimal;

/**
 * Interface for Basket.
 */
public interface IBasket {


    void add(IGenericItem item);

    void remove(final String itemName);

    BigDecimal calculateCost();

    Integer itemCount();
}
