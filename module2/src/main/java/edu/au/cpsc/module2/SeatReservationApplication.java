package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class SeatReservationApplication extends Application {
    private SeatReservation seatReservation;
    private TextField flightDesignatorField;
    private DatePicker fdatePicker;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField numberbagsField;
    private CheckBox infantCheckBox;
    @Override
    public void start(Stage stage) {
        seatReservation  = new SeatReservation();
        TextField textField  = new TextField();
        BorderPane borderPane = new BorderPane();
        CheckBox checkBox = new CheckBox();
        DatePicker datePicker = new DatePicker();
        GridPane gridPane = createGridPane();
        HBox hBox = createHBox();
        seatReservation.setFlightDesignator("DL1331");
        seatReservation.setFlightDate(LocalDate.of(2023, 7, 30));
        seatReservation.setFirstName("Tom");
        seatReservation.setLastName("Brady");
        seatReservation.setNumberOfBags(1);
        seatReservation.makeNotFlyingWithInfant();


        borderPane.setCenter(gridPane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane,320, 240);
        stage.setTitle("Seat Reservation Editor");
        stage.setScene(scene);
        updateUI();
        stage.show();
    }

    private void updateUI() {
        flightDesignatorField.setText(seatReservation.getFlightDesignator());
        fdatePicker.setValue(seatReservation.getFlightDate());
        firstNameField.setText(seatReservation.getFirstName());
        lastNameField.setText(seatReservation.getLastName());
        numberbagsField.setText(String.valueOf(seatReservation.getNumberOfBags()));
        infantCheckBox.setSelected(seatReservation.getIsFlyingWithInfant());


    }

    private HBox createHBox() {
        HBox hBox = new HBox(10);
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> {
            System.out.println("Cancel clicked");
            Platform.exit();
        });
        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            try {
                seatReservation.setFlightDesignator(flightDesignatorField.getText());
                seatReservation.setFlightDate(LocalDate.parse(fdatePicker.getValue().toString()));
                seatReservation.setFirstName(firstNameField.getText());
                seatReservation.setLastName(lastNameField.getText());
                seatReservation.setNumberOfBags(Integer.parseInt(numberbagsField.getText()));
                if (infantCheckBox.isSelected()) {
                    seatReservation.makeFlyingWithInfant();
                }
                else {
                    seatReservation.makeNotFlyingWithInfant();
                }
                System.out.println(seatReservation);
                Platform.exit();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Designator must be 4-6 characters in length.");
            }
        });
        hBox.getChildren().addAll(cancelButton, saveButton);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);

        return hBox;
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        flightDesignatorField = new TextField();
        fdatePicker = new DatePicker();
        firstNameField = new TextField();
        lastNameField = new TextField();
        numberbagsField = new TextField();
        infantCheckBox = new CheckBox();

        gridPane.add(new Label("Flight Designator:"), 0, 0);
        gridPane.add(flightDesignatorField, 1, 0);
        gridPane.add(new Label("Flight Date:"), 0, 1);
        gridPane.add(fdatePicker, 1, 1);
        gridPane.add(new Label("First name:"), 0, 2);
        gridPane.add(firstNameField, 1, 2);
        gridPane.add(new Label("Last name:"), 0, 3);
        gridPane.add(lastNameField, 1, 3);
        gridPane.add(new Label("Bags:"), 0, 4);
        gridPane.add(numberbagsField, 1, 4);
        gridPane.add(new Label("Flying with infant?"), 0, 5);
        gridPane.add(infantCheckBox, 1, 5);
        gridPane.add(new Label("Number of passengers:"), 0, 6);
        TextField tField = new TextField("1");
        tField.setEditable(false);
        gridPane.add(tField, 1, 6);
        infantCheckBox.setOnAction(event -> {
            if (infantCheckBox.isSelected()) {
                tField.setText("2");
            }
            else {
                tField.setText("1");
            }
        });



        return gridPane;
    }

    public static void main(String[] args) {
        launch();
    }
}