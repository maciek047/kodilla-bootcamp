package com.kodilla.good.patterns.airportApp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class FlightSearchProcessor {

    private SearchRequest currentSearch;
    public FlightSearchProcessor(SearchRequest currentSearch) {
        this.currentSearch = currentSearch;
    }

    public void process(){

        final List<AirportCity> airportsSchedule = FlightGenerator.generate();

        if(this.currentSearch.getViaCity()==null){
            List<Flight> searchResult = search(airportsSchedule,currentSearch.getDepartureCity(),currentSearch.getDestinationCity());
            for(Flight flight : searchResult){
                System.out.println(flight);
            }
        } else {
            List<Flight> flightsFromViaCity = search(airportsSchedule,currentSearch.getViaCity(),currentSearch.getDestinationCity());
            List<Flight> flightsToViaCity = search(airportsSchedule,currentSearch.getDepartureCity(),currentSearch.getViaCity());

            for (Flight flight1 : flightsToViaCity) {
                for (Flight flight2 : flightsFromViaCity) {
                    if (flight2.getDayOfweek() == flight1.getDayOfweek()
                            && flight2.getHourOfDeparture() > flight1.getHourOfArrival()) {
                        System.out.println("Flight 1/2: " + flight1 + " || Flight 2/2: " + flight2);
                    }
                }
            }
        }
    }

    public List<Flight> search(List<AirportCity> airportsSchedule, AirportCity from, AirportCity to){
        return airportsSchedule.stream()
                .map(AirportCity::getOutgoingFlights)
                .flatMap(Collection::stream)
                .filter(n->(to==null)? true : n.getDestination().equals(to))
                .filter(n->(from==null)? true : n.getOrigin().equals(from))
                .collect(Collectors.toList());
    }
}
