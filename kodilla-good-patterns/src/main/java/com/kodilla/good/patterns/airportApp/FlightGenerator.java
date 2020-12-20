package com.kodilla.good.patterns.airportApp;

import java.util.*;

public class FlightGenerator {

    static List<AirportCity> generate(){
        List<String> airportNames = new ArrayList<>();
        airportNames.add("Gdansk");
        airportNames.add("Warszawa");
        airportNames.add("Wroclaw");
        airportNames.add("Krakow");
        airportNames.add("Berlin");
        airportNames.add("Paryz");
        airportNames.add("Londyn");
        airportNames.add("Madryt");
        airportNames.add("Rzym");
        airportNames.add("Sztokholm");
        airportNames.add("Ateny");
        airportNames.add("Moskwa");

        Random random = new Random();
        List<AirportCity> airports = new ArrayList<>();
        List<Flight> flights = new ArrayList<>();

        for (String airportName : airportNames) {
            airports.add(new AirportCity(airportName));
        }
        int tempIndex;
        int tempIndex2;

        for(int i=0;i<300;i++){
            tempIndex = random.nextInt(airports.size());
            tempIndex2 = random.nextInt(airports.size());
            while(tempIndex==tempIndex2){
                tempIndex2 = random.nextInt(airports.size());
            }

            int tempHourDeparture = random.nextInt(24)*100;
            int tempHourArrival = random.nextInt(24)*100;
            tempHourDeparture = tempHourDeparture + random.nextInt(60);
            tempHourArrival = tempHourArrival + random.nextInt(60);

            while(tempHourDeparture > tempHourArrival){
                tempHourDeparture = random.nextInt(24)*100;
                tempHourArrival = random.nextInt(24)*100;
                tempHourDeparture = tempHourDeparture + random.nextInt(60);
                tempHourArrival = tempHourArrival + random.nextInt(60);
            }

            Flight tempFlight = new Flight(airports.get(tempIndex),airports.get(tempIndex2),random.nextInt(7),tempHourDeparture,tempHourArrival);
            flights.add(tempFlight);
            airports.get(tempIndex2).addOutgoingFlight(tempFlight);
        }
        return airports;
    }
}
