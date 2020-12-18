package com.kodilla.good.patterns.challenges;

public class PurchaseRequest {
    private double priceFrom;
    private double priceTo;
    private Product product;

    public PurchaseRequest(double priceFrom, double priceTo, Product product) {
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.product = product;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public Product getProduct() {
        return product;
    }
}
