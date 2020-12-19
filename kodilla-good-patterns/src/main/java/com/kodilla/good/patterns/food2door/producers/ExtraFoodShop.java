package com.kodilla.good.patterns.food2door.producers;
import com.kodilla.good.patterns.food2door.*;

public class ExtraFoodShop implements Producer {

    final double shippingCost;

    public ExtraFoodShop() {
        this.shippingCost = 12.33;
    }

    public orderDto process(Product product, double quantity){
        double totalAmount = (product.getProductPrice() * quantity) + this.shippingCost;
        if(product.getProductAvailableAmount() >= quantity){
            SendOrderToProducer send = new SendOrderEmail();
            send.send(product, quantity);
            return new orderDto(true, totalAmount);
        } else {
            return new orderDto(false, 0.00);
        }
    }
}
