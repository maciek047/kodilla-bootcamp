package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    public static void main(String[] args) {
        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        PurchaseRequest purchaseRequest = purchaseRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new MailService(), new ElectronicsPurchaseService(), new ElectronicsPurchaseRepository());
        purchaseDto result = orderProcessor.process(purchaseRequest);
        if(result.isResult()){
            System.out.println("Product purchased: " + result.getProduct().getProductName());
        } else System.out.println("Product unavailable.");

    }
}
