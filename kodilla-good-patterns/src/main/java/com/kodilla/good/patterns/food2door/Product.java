package com.kodilla.good.patterns.food2door;

public class Product {

    private String name;
    private Producer productProducer;
    private double productPrice;
    private double productAvailableAmount;

    public Product(String name, Producer productProducer, double productPrice, double productAvailableAmount) {
        this.name = name;
        this.productProducer = productProducer;
        this.productPrice = productPrice;
        this.productAvailableAmount = productAvailableAmount;
    }

    public String getName() { return name; }

    public Producer getProductProducer() {
        return productProducer;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getProductAvailableAmount() {
        return productAvailableAmount;
    }
}
