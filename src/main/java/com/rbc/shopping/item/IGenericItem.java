package com.rbc.shopping.item;

import com.rbc.shopping.visitor.ShoppingCartVisitor;

import java.math.BigDecimal;

/**
 * Interface for product item.
 */
public interface IGenericItem {

    /**
     * Each item in basket accept visitor to calculate cost.
     *
     * @param visitor {@link ShoppingCartVisitor}
     * @return cost of item
     */
    BigDecimal accept(ShoppingCartVisitor visitor);

    /**
     * get name of item.
     *
     * @return name
     */
    String getName();
}
