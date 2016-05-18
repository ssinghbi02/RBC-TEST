package com.rbc.shopping.visitor;

import com.rbc.shopping.item.FruitItem;

import java.math.BigDecimal;

/**
 * Visitor class for shopping cart item.
 */
public interface ShoppingCartVisitor {

    /**
     * This method is used to visit each item in basket and calculate cost of item.
     *
     * @param fruit {@code FruitItem}
     * @return calculated cost of item
     */
    BigDecimal visit(FruitItem fruit);
}
