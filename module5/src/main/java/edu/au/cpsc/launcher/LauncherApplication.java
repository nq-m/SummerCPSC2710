package edu.au.cpsc.launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LauncherApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/launcher/style/launcher-app.fxml")
        );


        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        scene.getStylesheets().add(
                getClass().getResource("/launcher/style/main.css").toExternalForm()
        );

        primaryStage.setTitle("Part 1 View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}