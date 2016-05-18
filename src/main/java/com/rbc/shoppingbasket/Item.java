package com.rbc.shoppingbasket;

import java.math.BigDecimal;

/**
 * This is immutable class for basket item.
 */
public class Item {
    private final Integer id;
    private final String name;
    private final BigDecimal price;
    private final String description;
    private final Integer quantity;

    public Item(final Integer id, final String name, final BigDecimal price, final String description, final Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
