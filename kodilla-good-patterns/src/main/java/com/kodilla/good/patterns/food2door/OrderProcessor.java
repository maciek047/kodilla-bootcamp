package com.kodilla.good.patterns.food2door;

import java.util.*;

public class OrderProcessor {

    public boolean submit(OrderRequest order) {
        boolean rtn = true;
        double totalAmount = 0.00;
        List<Product> productList = order.getOrderProductList();
        double[] productQuantities = order.getProductQuantity();
        for (int i = 0; i < productList.size(); i++) {
            Product tempProduct = productList.get(i);
            orderDto result = tempProduct.getProductProducer().process(tempProduct,productQuantities[i]);
            if(result.getResult()){
                totalAmount += result.getAmount();
            } else {
                System.out.println("product: " + tempProduct.getName() + " not available!");
                rtn = false;
            }
        }
        System.out.println("orders submitted, total amount: " + totalAmount);
        return rtn;
    }
}
