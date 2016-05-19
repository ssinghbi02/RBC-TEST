package com.rbc.shopping.basket;

import com.rbc.shopping.item.IGenericItem;
import com.rbc.shopping.visitor.ShoppingCartVisitor;
import com.rbc.shopping.visitor.ShoppingCartVisitorImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class Basket implements IBasket {
    private List<IGenericItem> cart;
    private ShoppingCartVisitor visitor;

    public Basket() {
        this.cart = new ArrayList<IGenericItem>();
        visitor = new ShoppingCartVisitorImpl();
    }

    @Override
    public void add(IGenericItem fruitItem) {
        cart.add(fruitItem);
    }

    @Override
    public void remove(final String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalStateException("Item name must be non empty.");
        }

        for (IGenericItem item : cart) {
            if (itemName.equals(item.getName())) {
                cart.remove(item);
            }
        }
    }

    @Override
    public BigDecimal calculateCost() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (IGenericItem item : cart) {
            BigDecimal itemPrice = item.accept(visitor);
            totalPrice = totalPrice.add(itemPrice);
        }
        return totalPrice;
    }

    public Integer itemCount() {
        return cart.size();
    }
}
