package com.rbc.shopping.visitor;

import com.rbc.shopping.item.FruitItem;

import java.math.BigDecimal;

/**
 * {@inheritDoc}
 */
public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal visit(FruitItem fruit) {
        return fruit.getPricePerKg().multiply(fruit.getWeight());
    }

}
