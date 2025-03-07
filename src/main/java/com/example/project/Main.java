package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static String user = "Student"; // Manual login placeholder for testing

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        switchToView();
    }

    private void switchToView() throws IOException {
        String fxmlFile = "";

        if ("Admin".equals(user)) {
            fxmlFile = "AdminView.fxml";
        } else if ("Faculty".equals(user)) {
            fxmlFile = "FacultyView.fxml";
        } else if ("Student".equals(user)) {
            fxmlFile = "StudentView.fxml";
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/project/" + fxmlFile));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(user + " View");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
