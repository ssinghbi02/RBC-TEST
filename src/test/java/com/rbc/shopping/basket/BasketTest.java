package com.rbc.shopping.basket;

import com.rbc.shopping.item.FruitItem;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This is test class for {@link Basket}
 */
public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void testAddItem() {
        basket.add(new FruitItem(new BigDecimal(1.99), new BigDecimal(1.2), "BANANA"));
        basket.add(new FruitItem(new BigDecimal(2.99), new BigDecimal(1.2), "APPLE"));
        assertThat(basket.itemCount(), is(2));
    }

    @Test
    public void testRemoveItem() {
        basket.add(new FruitItem(new BigDecimal(1.99), new BigDecimal(1.2), "BANANA"));
        basket.add(new FruitItem(new BigDecimal(1.99), new BigDecimal(1.2), "APPLE"));
        assertThat(basket.itemCount(), is(2));
        basket.remove("BANANA");
        assertThat(basket.itemCount(), is(1));
    }

    @Test(expected = IllegalStateException.class)
    public void testThrowExceptionOnRemoveIfPassedInItemIsEmpty() {
        basket.remove("");
    }

    @Test(expected = IllegalStateException.class)
    public void testThrowExceptionOnRemoveIfPassedInItemIsNull() {
        basket.remove(null);
    }

    @Test
    public void testCalculateTotalCost() {
        basket.add(new FruitItem(new BigDecimal(2.0), new BigDecimal(1.2), "BANANA"));
        basket.add(new FruitItem(new BigDecimal(3.0), new BigDecimal(1.5), "APPLE"));
        assertThat(basket.calculateCost().doubleValue(), is(6.9));
    }
}
