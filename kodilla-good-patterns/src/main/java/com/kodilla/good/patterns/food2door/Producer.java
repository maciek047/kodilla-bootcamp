package com.kodilla.good.patterns.food2door;

public interface Producer {
    public orderDto process(Product product,double quantity);
}
