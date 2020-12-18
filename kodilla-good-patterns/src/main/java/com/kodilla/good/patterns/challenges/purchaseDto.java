package com.kodilla.good.patterns.challenges;

public class purchaseDto {
    Product product;
    boolean result;

    public purchaseDto(Product product, boolean result) {
        this.product = product;
        this.result = result;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isResult() {
        return result;
    }
}
