package com.kodilla.exception.test;
import java.util.HashMap;

public class FlightSearch {
    public String findFlight(Flight flight) throws RouteNotFoundException {
        String message;
        HashMap<String, Boolean> flightMap = new HashMap<String, Boolean>();
        flightMap.put("London",true);
        flightMap.put("Paris",true);
        flightMap.put("NewYork",false);
        flightMap.put("Tokyo",false);
        flightMap.put("Warsaw",true);

        if (flightMap.containsKey(flight.getDepartureAirport()) && flightMap.containsKey(flight.getArrivalAirport())){
            if (flightMap.get(flight.getArrivalAirport()) && flightMap.get(flight.getDepartureAirport())){
                message =  "Flight is available! :)";
            } else {
                message = "Flight not available :(";
            }
        } else {
            throw new RouteNotFoundException("Airport not found!");
        }
        return message;
    }
}
