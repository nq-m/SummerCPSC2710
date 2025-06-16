package edu.au.cpsc.module4.model;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScheduledFlight {

    public static List<ScheduledFlight> demoScheduledFlight() {
        Set<String> days = new HashSet<>();
        return List.of(new ScheduledFlight("AA1234", "BHM", LocalTime.of(1,0), "PIT", LocalTime.of(4, 0), new HashSet<>(days)));
    }
    private String flightDesignator;
    private String departureAirportIdent;
    private LocalTime departureTime ;
    private String arrivalAirportIdent;
    private LocalTime arrivalTime;
    private HashSet<String> daysOfWeek;

    public ScheduledFlight(String flightDesignator, String departureAirportIdent, LocalTime departureTime, String arrivalAirportIdent, LocalTime arrivalTime, HashSet<String> daysOfWeek) {
        this.flightDesignator = flightDesignator;
        this.departureAirportIdent = departureAirportIdent;
        this.departureTime = departureTime;
        this.arrivalAirportIdent = arrivalAirportIdent;
        this.arrivalTime = arrivalTime;
        this.daysOfWeek = daysOfWeek;
    }
    public String getFlightDesignator() {
        return flightDesignator;
    }
    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) {
            throw new IllegalArgumentException();
        }
        this.flightDesignator = flightDesignator;
    }
    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }
    public void setDepartureAirportIdent(String departureAirportIdent) {
        if (departureAirportIdent == null) {
            throw new IllegalArgumentException();
        }
        this.departureAirportIdent = departureAirportIdent;
    }
    public LocalTime getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null) {
            throw new IllegalArgumentException();
        }
        this.departureTime = departureTime;
    }
    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }
    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if (arrivalAirportIdent == null) {
            throw new IllegalArgumentException();
        }
        this.arrivalAirportIdent = arrivalAirportIdent;
    }
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null) {
            throw new IllegalArgumentException();
        }
        this.arrivalTime = arrivalTime;
    }
    public HashSet<String> getDaysOfWeek() {
        return daysOfWeek;
    }
    public void setDaysOfWeek(HashSet<String> daysOfWeek) {
        if (daysOfWeek == null) {
            throw new IllegalArgumentException();
        }
        this.daysOfWeek = daysOfWeek;
    }


}