package com.kodilla.good.patterns.food2door;

public class SendOrderEmail implements SendOrderToProducer {
    public boolean send(Product product, double quantity) {
        System.out.println("sending order via Email... " + product.getName() + " x " +quantity);
        return true;
    }
}