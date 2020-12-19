package com.kodilla.good.patterns.food2door;

public class food2door {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor();
        boolean result = orderProcessor.submit(orderRequest);
        if(result){
            System.out.println("all orders successfully submitted!");
        } else System.out.println("orders partially submitted.");
    }
}
