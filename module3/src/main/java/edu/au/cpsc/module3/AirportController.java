package edu.au.cpsc.module3;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import edu.au.cpsc.module3.Airport;

public class AirportController {

    @FXML
    private TextField identField;
    @FXML
    private TextField iataField;
    @FXML
    private TextField localCodeField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField elevationField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField regionField;
    @FXML
    private TextField municipalityField;
    @FXML
    private WebView mapView;

    private WebEngine webEngine;

    @FXML
    public void initialize() {
        webEngine = mapView.getEngine();
    }

    private void updateMap(double latitude, double longitude) {
        String url = String.format("https://www.windy.com/?%f,%f,12", latitude, longitude);
        webEngine.load(url);
    }

    public void displayAirport(Airport airport) {
        if (airport == null) return;

        identField.setText(airport.ident);
        iataField.setText(airport.iataCode);
        localCodeField.setText(airport.localCode);
        typeField.setText(airport.type);
        nameField.setText(airport.name);
        elevationField.setText(airport.elevationInFeet != null ? airport.elevationInFeet.toString() : "");
        countryField.setText(airport.isoCountry);
        regionField.setText(airport.isoRegion);
        municipalityField.setText(airport.municipality);

        updateMap(airport.latitude, airport.longitude);
    }
}

