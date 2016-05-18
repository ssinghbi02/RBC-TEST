package com.rbc.shopping.item;

import com.rbc.shopping.visitor.ShoppingCartVisitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

/**
 * This is test class for {@code Item}
 */
@RunWith(MockitoJUnitRunner.class)
public class FruitItemTest {

    private static final String FRUIT_NAME = "BANANA";
    private FruitItem item;

    @Mock
    private ShoppingCartVisitor mockShoppingCartVisitor;

    @Test
    public void testItemInitialisation() {
        item = new FruitItem(new BigDecimal(1.99), new BigDecimal(1.5), FRUIT_NAME);
        assertThat(item.getName(), is("BANANA"));
        assertThat(item.getPricePerKg().doubleValue(), is(1.99));
        assertThat(item.getWeight().doubleValue(), is(1.5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionIfPriceIszero() {
        item = new FruitItem(new BigDecimal(0), new BigDecimal(1.5), FRUIT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionIfPriceIsNegative() {
        item = new FruitItem(new BigDecimal(-5), new BigDecimal(1.5), FRUIT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionIfPriceIsNull() {
        item = new FruitItem(null, new BigDecimal(1.5), FRUIT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionIfWeightIszero() {
        item = new FruitItem(new BigDecimal(1.99), new BigDecimal(0), FRUIT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionIfWeightIsNegative() {
        item = new FruitItem(new BigDecimal(1.99), new BigDecimal(-7), FRUIT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowExceptionIfWeightIsNull() {
        item = new FruitItem(new BigDecimal(1.99), null, FRUIT_NAME);
    }

    @Test
    public void testAccept() {
        item = new FruitItem(new BigDecimal(1.99), new BigDecimal(1.5), FRUIT_NAME);
        item.accept(mockShoppingCartVisitor);
        verify(mockShoppingCartVisitor).visit(item);
    }

}
