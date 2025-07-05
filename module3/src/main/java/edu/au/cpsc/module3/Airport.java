package edu.au.cpsc.module3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airport {
    public String ident;
    public String type;
    public String name;
    public Integer elevationInFeet;
    public String continent;
    public String isoCountry;
    public String isoRegion;
    public String municipality;
    public String gpsCode;
    public String iataCode;
    public String localCode;
    public double longitude;
    public double latitude;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getElevationInFeet() {
        return elevationInFeet;
    }

    public void setElevationInFeet(Integer elevationInFeet) {
        this.elevationInFeet = elevationInFeet;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getLocalCode() { return localCode; }

    public void setLocalCode(String localCode) { this.localCode = localCode; }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public static List<Airport> readAll(String fileName) throws IOException {
        List<Airport> airports = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine(); //
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",", -1);
                if (tokens.length < 13) continue;

                Airport airport = new Airport();
                airport.ident = tokens[0];
                airport.type = tokens[1];
                airport.name = tokens[2];
                airport.elevationInFeet = tokens[3].isEmpty() ? null : Integer.parseInt(tokens[3]);
                airport.continent = tokens[4];
                airport.isoCountry = tokens[5];
                airport.isoRegion = tokens[6];
                airport.municipality = tokens[7];
                airport.gpsCode = tokens[8];
                airport.iataCode = tokens[9];
                airport.localCode = tokens[10];

                if (!tokens[11].isEmpty() && !tokens[12].isEmpty()) {
                    try {
                        airport.longitude = Double.parseDouble(tokens[11].trim());
                        airport.latitude = Double.parseDouble(tokens[12].trim());
                    } catch (NumberFormatException e) {
                        continue;
                    }
                } else {
                    continue;
                }

                airports.add(airport);
            }
        }
        return airports;
    }
}


