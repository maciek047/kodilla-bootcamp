package com.kodilla.good.patterns.food2door;
import java.util.List;

public class OrderRequest {
    private double[] productQuantity;
    private List<Product> orderProductList;

    public OrderRequest(double[] productQuantity, List<Product> orderProductList) {
        this.productQuantity = productQuantity;
        this.orderProductList = orderProductList;
    }

    public double[] getProductQuantity() {
        return productQuantity;
    }
    public List<Product> getOrderProductList() {
        return orderProductList;
    }
}
