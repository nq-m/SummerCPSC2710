package edu.au.cpsc.module4.data;

import edu.au.cpsc.module4.model.ScheduledFlight;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AirlineDatabase implements Serializable {
    private List<ScheduledFlight> scheduledFlights;

    public AirlineDatabase() {
        scheduledFlights = new ArrayList<>();

    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void addScheduledFlight(ScheduledFlight sf) {
        scheduledFlights.add(sf);
    }

    public void removeScheduledFlight(ScheduledFlight sf) {
        scheduledFlights.remove(sf);
    }

    public void updateScheduledFlight(ScheduledFlight sf) {

    }
}