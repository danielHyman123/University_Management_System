package engg1420_project.universitymanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    @FXML
    private void onHelloButtonClick() {
        // Implement logic for Dashboard button click here
    }

    @FXML
    private void openEventManagement() throws IOException {
        System.out.println("Event Management Clicked!");

        // Create a new Stage for Event Management
        Stage stage = new Stage();
        stage.setTitle("Event Management");

        // Load the EventManagement.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EventManagement.fxml"));
        AnchorPane root = loader.load();  // Load the FXML into the root layout

        // Create a scene with the loaded root layout
        Scene scene = new Scene(root, 800, 600);

        // Set the scene and show the new window
        stage.setScene(scene);
        stage.show();
    }
}
