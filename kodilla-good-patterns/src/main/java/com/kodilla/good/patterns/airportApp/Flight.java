package com.kodilla.good.patterns.airportApp;

public class Flight {
    private AirportCity destination;
    private AirportCity origin;
    private int dayOfweek;
    private int hourOfDeparture;
    private int hourOfArrival;

    public Flight(AirportCity destination, AirportCity origin, int dayOfweek, int hourOfDeparture, int hourOfArrival) {
        this.destination = destination;
        this.origin = origin;
        this.dayOfweek = dayOfweek;
        this.hourOfDeparture = hourOfDeparture;
        this.hourOfArrival = hourOfArrival;
    }

    public AirportCity getDestination() {
        return destination;
    }

    public AirportCity getOrigin() { return origin; }

    public int getDayOfweek() {
        return dayOfweek;
    }

    public int getHourOfDeparture() {
        return hourOfDeparture;
    }

    public int getHourOfArrival() {
        return hourOfArrival;
    }

    public String hourFormat(int hour){
        String tempHour = Integer.toString(hour);
        if(tempHour.length()>2) {
            return tempHour.substring(0,tempHour.length()-2)  + ":" + tempHour.substring(tempHour.length()-2);
        } else {
            return "0:"+ tempHour;
        }
    }

    @Override
    public String toString() {
        String[] daysOfweek = new String[7];
        daysOfweek[0]="Mon";
        daysOfweek[1]="Tue";
        daysOfweek[2]="Wed";
        daysOfweek[3]="Thu";
        daysOfweek[4]="Fri";
        daysOfweek[5]="Sat";
        daysOfweek[6]="Sun";
        return  "To: " + destination.getCityName() +
                ", From: " + origin.getCityName() +
                ", " + daysOfweek[dayOfweek] +
                " " + hourFormat(hourOfDeparture) +
                " - " + hourFormat(hourOfArrival);
    }
}
