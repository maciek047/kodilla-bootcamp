package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBigItalianPizzaWithPepperoni() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new ItalianCrustDecorator(pizzaOrder);
        pizzaOrder = new PepperoniDecorator(pizzaOrder);
        pizzaOrder = new BigSizeDecorator(pizzaOrder);
        System.out.println("Pizza price: " + pizzaOrder.getPrice());
        System.out.println("Pizza desc.: " + pizzaOrder.getDescription());
        //When
        BigDecimal price = pizzaOrder.getPrice();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("You've ordered a pizza on italian crust + pepperoni, large (51cm)", description);
        assertEquals(new BigDecimal(30), price);
    }
    @Test
    public void testAmericanPizzaWithExtraCheese() {
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AmericanCrustDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        System.out.println("Pizza price: " + pizzaOrder.getPrice());
        System.out.println("Pizza desc.: " + pizzaOrder.getDescription());
        //When
        BigDecimal price = pizzaOrder.getPrice();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("You've ordered a pizza on american crust with extra cheese", description);
        assertEquals(new BigDecimal(21), price);
    }
}
