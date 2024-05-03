package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file explicitly by providing the file location
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/GadgetShop.fxml"));
            GridPane root = (GridPane) loader.load();

            // Create a new scene with the loaded root and set the size
            Scene scene = new Scene(root, 400, 400);

            // Set the scene to the primary stage and show it
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // Handle the exception gracefully
            System.err.println("Error loading FXML file: " + e.getMessage());
            // Display an alert dialog to inform the user about the error
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Unable to load application");
            alert.setContentText("An error occurred while loading the application. Please try again later.");
            alert.showAndWait();
            // Optionally, you can close the application or perform other actions based on
            // the error
            e.printStackTrace();
            // Exit the application
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
