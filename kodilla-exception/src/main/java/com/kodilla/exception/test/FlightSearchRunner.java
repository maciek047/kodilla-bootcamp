package com.kodilla.exception.test;

public class FlightSearchRunner {
    public static void main(String[] args) {

        Flight myFlight = new Flight("London","kosmos");
        FlightSearch flightSearch = new FlightSearch();

        try {
            System.out.println(flightSearch.findFlight(myFlight));
        } catch (RouteNotFoundException e){
            System.out.println("Airport not found, please try again...");
        }
    }
}
