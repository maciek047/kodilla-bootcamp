package com.kodilla.good.patterns.airportApp;

public class SearchRequest {
    private AirportCity departureCity;
    private AirportCity destinationCity;
    private AirportCity viaCity;

    public SearchRequest(AirportCity departureCity, AirportCity destinationCity, AirportCity viaCity) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.viaCity = viaCity;
    }

    public AirportCity getDepartureCity() {
        return departureCity;
    }

    public AirportCity getDestinationCity() {
        return destinationCity;
    }

    public AirportCity getViaCity() { return viaCity; }
}
