package com.kodilla.good.patterns.challenges;

public class PurchaseRequestRetriever {

    public PurchaseRequest retrieve() {
        Product product = new Product("playstation 5");
        double priceFrom = 1000.00;
        double priceTo = 1999.99;

        return new PurchaseRequest(priceFrom,priceTo,product);

    }
}
