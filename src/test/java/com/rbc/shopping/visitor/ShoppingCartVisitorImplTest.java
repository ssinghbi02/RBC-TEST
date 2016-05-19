package com.rbc.shopping.visitor;

import com.rbc.shopping.item.FruitItem;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Test class for {@link ShoppingCartVisitor}
 */
public class ShoppingCartVisitorImplTest {

    private ShoppingCartVisitor shoppingCartVisitor;

    @Before
    public void setUp() {
        shoppingCartVisitor = new ShoppingCartVisitorImpl();
    }

    @Test
    public void testVisit() {
        shoppingCartVisitor = new ShoppingCartVisitorImpl();
        BigDecimal cost = shoppingCartVisitor.visit(new FruitItem(new BigDecimal(2.0), new BigDecimal(1.2), "BANANA"));
        assertThat(cost.doubleValue(), is(2.4));
    }
}
