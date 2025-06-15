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
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(",", -1);
            if (tokens.length < 12) continue;
            String ident = tokens[0];
            String type = tokens[1];
            String name = tokens[2];
            Integer elevation = tokens[3].isEmpty() ? null : Integer.parseInt(tokens[3]);
            String continent = tokens[4];
            String isoCountry = tokens[5];
            String isoRegion = tokens[6];
            String municipality = tokens[7];
            String gpsCode = tokens[8];
            String iataCode = tokens[9];
            String[] coordinates = tokens[11].split(" ");
            double longitude = Double.parseDouble(coordinates[0]);
            double latitude = Double.parseDouble(coordinates[1]);
        }
        bufferedReader.close();
        return airports;
    }

}
