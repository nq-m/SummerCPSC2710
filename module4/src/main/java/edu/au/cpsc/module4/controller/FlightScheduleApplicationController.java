package edu.au.cpsc.module4.controller;

import edu.au.cpsc.module4.model.ScheduledFlight;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalTime;
import java.util.HashSet;

public class FlightScheduleApplicationController {
    @FXML
    private TableView<ScheduledFlight> flighttableView;
    @FXML
    private TextField flightDesignatorField;
    @FXML
    private TextField departureAirportField;
    @FXML
    private TextField arrivalAirportField;

    @FXML
    private ToggleButton mondayButton;
    @FXML
    private ToggleButton tuesdayButton;
    @FXML
    private ToggleButton wednesdayButton;
    @FXML
    private ToggleButton thursdayButton;
    @FXML
    private ToggleButton fridayButton;
    @FXML
    private ToggleButton saturdayButton;
    @FXML
    private ToggleButton sundayButton;

    @FXML
    private Button addButton;
    @FXML
    private Button newButton;
    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<ScheduledFlight, String> flightdesignatorColumn, departureairportColumn, arrivalairportColumn, daysofweekColumn;

    public void initialize() {
        flightdesignatorColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("flightDesignator"));
        departureairportColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("departureAirportIdent"));
        arrivalairportColumn.setCellValueFactory(new PropertyValueFactory<ScheduledFlight, String>("arrivalAirportIdent"));
        daysofweekColumn.setCellValueFactory(cellData -> {
            HashSet<String> daysSet = cellData.getValue().getDaysOfWeek();
            String daysString = String.join("", daysSet);
            return new javafx.beans.property.SimpleStringProperty(daysString);
        });
        flighttableView.setItems(javafx.collections.FXCollections.observableArrayList());
        flighttableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                addButton.setText("Update");

                // Populate form fields
                flightDesignatorField.setText(newSelection.getFlightDesignator());
                departureAirportField.setText(newSelection.getDepartureAirportIdent());
                arrivalAirportField.setText(newSelection.getArrivalAirportIdent());

                // Clear toggle buttons
                mondayButton.setSelected(false);
                tuesdayButton.setSelected(false);
                wednesdayButton.setSelected(false);
                thursdayButton.setSelected(false);
                fridayButton.setSelected(false);
                saturdayButton.setSelected(false);
                sundayButton.setSelected(false);

                // Set toggle buttons
                for (String day : newSelection.getDaysOfWeek()) {
                    switch (day) {
                        case "M" -> mondayButton.setSelected(true);
                        case "T" -> tuesdayButton.setSelected(true);
                        case "W" -> wednesdayButton.setSelected(true);
                        case "R" -> thursdayButton.setSelected(true);
                        case "F" -> fridayButton.setSelected(true);
                        case "S" -> saturdayButton.setSelected(true);
                        case "U" -> sundayButton.setSelected(true);
                    }
                }
            }
        });
    }

    @FXML
    protected void addButtonAction() {
        String flightDesignator = flightDesignatorField.getText().trim();
        String departureAirport = departureAirportField.getText().trim();
        String arrivalAirport = arrivalAirportField.getText().trim();
        HashSet<String> days = new HashSet<>();
        if (mondayButton.isSelected()) {
            days.add("M");
        }
        if (tuesdayButton.isSelected()) {
            days.add("T");
        }
        if (wednesdayButton.isSelected()) {
            days.add("W");
        }
        if (thursdayButton.isSelected()) {
            days.add("R");
        }
        if (fridayButton.isSelected()) {
            days.add("F");
        }
        if (saturdayButton.isSelected()) {
            days.add("S");
        }
        if (sundayButton.isSelected()) {
            days.add("U");
        }
        ScheduledFlight theFlight = flighttableView.getSelectionModel().getSelectedItem();
        if (theFlight != null) {
            theFlight.setFlightDesignator(flightDesignator);
            theFlight.setDepartureAirportIdent(departureAirport);
            theFlight.setArrivalAirportIdent(arrivalAirport);
            theFlight.setDaysOfWeek(days);

            // Refresh the table
            flighttableView.refresh();

            // Reset form
            newMenuAction();
        } else {
            ScheduledFlight newFlight = new ScheduledFlight(flightDesignator, departureAirport, LocalTime.of(1,0), arrivalAirport, LocalTime.of(1,0), days);
            flighttableView.getItems().add(newFlight);

            // Clear form
            newMenuAction();
        }
    }
    @FXML
    protected void newMenuAction() {
        flightDesignatorField.clear();
        departureAirportField.clear();
        arrivalAirportField.clear();
        mondayButton.setSelected(false);
        tuesdayButton.setSelected(false);
        wednesdayButton.setSelected(false);
        thursdayButton.setSelected(false);
        fridayButton.setSelected(false);
        saturdayButton.setSelected(false);
        sundayButton.setSelected(false);

        addButton.setText("Add");
        flighttableView.getSelectionModel().clearSelection();
    }
    @FXML
    protected void deleteMenuAction() {
        ScheduledFlight selectedflight = flighttableView.getSelectionModel().getSelectedItem();
        if (selectedflight != null) {
            flighttableView.getItems().remove(selectedflight);
            newMenuAction();
        }
    }

}