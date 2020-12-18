package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    public static void main(String[] args) {
        PurchaseRequestRetriever purchaseRequestRetriever = new PurchaseRequestRetriever();
        PurchaseRequest purchaseRequest = purchaseRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new MailService(), new ElectronicsPurchaseService(), new ElectronicsPurchaseRepository());
        orderProcessor.process(purchaseRequest);

    }
}
