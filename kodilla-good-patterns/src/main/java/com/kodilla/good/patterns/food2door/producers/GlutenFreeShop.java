package com.kodilla.good.patterns.food2door.producers;

import com.kodilla.good.patterns.food2door.*;

import java.util.concurrent.Executor;

public class GlutenFreeShop implements Producer {

    final double shippingCost;
    final int maxOrderQuantity;

    public GlutenFreeShop() {
        this.shippingCost = 0.00;
        this.maxOrderQuantity = 5;
    }

    public orderDto process(Product product, double quantity){
        double totalAmount = (product.getProductPrice() * quantity) + shippingCost;
        if(quantity > maxOrderQuantity){
            System.out.println("max quantity of the product " + product.getName() + " is " + maxOrderQuantity + " pcs.");
            quantity = 5;
        }
        if(product.getProductAvailableAmount() >= quantity){
            SendOrderAPI send = new SendOrderAPI();
            send.send(product, quantity);
            return new orderDto(true, totalAmount);
        } else {
            return new orderDto(false, 0.00);
        }
    }
}
