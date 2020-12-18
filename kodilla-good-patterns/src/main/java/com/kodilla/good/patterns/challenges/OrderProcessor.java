package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private InformationService informationService;
    private PurchaseService purchaseService;
    private PurchaseRepository purchaseRepository;

    public OrderProcessor(final InformationService informationService,
                           final PurchaseService purchaseService,
                           final PurchaseRepository rentalRepository) {
        this.informationService = informationService;
        this.purchaseService = purchaseService;
        this.purchaseRepository = rentalRepository;
    }

    public purchaseDto process(final PurchaseRequest buyRequest) {
        boolean isAvailable = purchaseService.buy(buyRequest.getProduct(), buyRequest.getPriceFrom(),
                buyRequest.getPriceTo());

        if(isAvailable) {
            informationService.send(buyRequest.getProduct());
            purchaseRepository.placeOrder(buyRequest.getProduct(), buyRequest.getPriceFrom(), buyRequest.getPriceTo());
            return new purchaseDto(buyRequest.getProduct(), true);
        } else {
            return new purchaseDto(buyRequest.getProduct(), false);
        }
    }
}
