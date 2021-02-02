package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BigSizeDecorator extends AbstractPizzaOrderDecorator {
    public BigSizeDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", large (51cm)";
    }
}
