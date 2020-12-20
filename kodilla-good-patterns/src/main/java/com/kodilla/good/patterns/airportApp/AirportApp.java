package com.kodilla.good.patterns.airportApp;

public class AirportApp {
    public static void main(String[] args) {

        System.out.println("\nSearch all flights from: Gdansk");
        FlightSearchProcessor searchFrom = new FlightSearchProcessor(new SearchRequest(new AirportCity("Gdansk"),null,null));
        searchFrom.process();

        System.out.println("\nSearch all flights to: Londyn");
        FlightSearchProcessor searchTo = new FlightSearchProcessor(new SearchRequest(null,new AirportCity("Londyn"),null));
        searchTo.process();

        System.out.println("\nSearch flights to: Paryz via: Wroclaw");
        FlightSearchProcessor searchVia = new FlightSearchProcessor(new SearchRequest(null,new AirportCity("Paryz"),new AirportCity("Wroclaw")));
        searchVia.process();
    }
}
