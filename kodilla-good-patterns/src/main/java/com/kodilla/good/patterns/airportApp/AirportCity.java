package com.kodilla.good.patterns.airportApp;
import java.util.ArrayList;
import java.util.List;

public class AirportCity {
    final private String cityName;
    private List<Flight> outgoingFlights;

    public AirportCity(String cityName) {
        this.cityName = cityName;
        this.outgoingFlights = new ArrayList<>();
    }

    public String getCityName() { return cityName; }

    public List<Flight> getOutgoingFlights() { return outgoingFlights; }

    public void addOutgoingFlight(Flight flight) { this.outgoingFlights.add(flight); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirportCity)) return false;

        AirportCity that = (AirportCity) o;
        return getCityName().equals(that.getCityName());
    }

    @Override
    public int hashCode() {
        return getCityName().hashCode();
    }
}
