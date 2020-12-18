package com.kodilla.good.patterns.challenges;

public interface PurchaseRepository {
    void placeOrder(Product product, double priceFrom, double priceTo);
}
