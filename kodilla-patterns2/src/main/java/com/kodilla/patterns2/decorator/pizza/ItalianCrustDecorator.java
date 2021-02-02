package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ItalianCrustDecorator extends AbstractPizzaOrderDecorator {
    public ItalianCrustDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(1));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " on italian crust";
    }
}
