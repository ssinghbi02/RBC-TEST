package com.rbc.shopping.item;

import com.rbc.shopping.visitor.ShoppingCartVisitor;

import java.math.BigDecimal;

/**
 * {@inheritDoc}
 * this is immutable class.
 */
public final class FruitItem implements IGenericItem {

    private final BigDecimal pricePerKg;
    private final BigDecimal weight;
    private final String name;

    /**
     * constructor.
     *
     * @param pricePerKg price
     * @param weight     weight
     * @param name       name
     */
    public FruitItem(final BigDecimal pricePerKg, final BigDecimal weight, final String name) {
        if (pricePerKg == null || pricePerKg.compareTo(new BigDecimal(0)) <= 0) {
            throw new IllegalArgumentException("price can not be zero or null");
        }

        if (weight == null || weight.compareTo(new BigDecimal(0)) <= 0) {
            throw new IllegalArgumentException("weight can not be zero or null");
        }

        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);
    }
}
