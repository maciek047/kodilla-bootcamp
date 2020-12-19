package com.kodilla.good.patterns.food2door.producers;

import com.kodilla.good.patterns.food2door.*;

public class HealthyShop implements Producer {
    final double shippingCost;
    final double minOrderAmount;

    public HealthyShop() {
        this.shippingCost = 25.00;
        this.minOrderAmount = 99.00;
    }

    public orderDto process(Product product, double quantity){
        double totalAmount = (product.getProductPrice() * quantity) + shippingCost;
        if(product.getProductAvailableAmount() >= quantity){
            if(totalAmount >= minOrderAmount){
                SendOrderFax send = new SendOrderFax();
                send.send(product, quantity);
                return new orderDto(true, totalAmount);
            } else {
                System.out.println("minimal order amount was not reached for the product: " + product.getName());
                return new orderDto(false, 0.00);
            }
        } else {
            return new orderDto(false, 0.00);
        }
    }
}