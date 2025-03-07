package engg1420_project.universitymanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load(); // Load the FXML file

        Scene scene = new Scene(root); // Create a scene with the loaded FXML
        stage.setTitle("University Management System");
        stage.setScene(scene); // Set the scene
        stage.show(); // Show the stage
    }

    public static void main(String[] args) {
        launch();
    }
}
