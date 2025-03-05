package com.example.engg1420facultymanagement;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class FacultyProfileController {

    @FXML
    private ListView<String> coursesListView;

    @FXML
    public void initialize() {
        coursesListView.getItems().addAll("One", "Two", "Three");

        coursesListView.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();

            ContextMenu contextMenu = new ContextMenu();

            MenuItem viewStudents = new MenuItem();
            viewStudents.textProperty().bind(Bindings.format("View students in \"%s\"", cell.itemProperty()));
            viewStudents.setOnAction(event -> {
                String item = cell.getItem();

                try {
                    // Load the FXML for the Faculty-Profile.fxml file
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("students-list.fxml"));

                   // FacultyProfileController profileController = new FacultyProfileController();
                    //fxmlLoader.setController(profileController); //TODO create controller

                    // Load the scene from the FXML file
                    Parent root = fxmlLoader.load();

                    // Create a new stage (window)
                    Stage newStage = new Stage();

                    // Create a new scene and set it for the new stage
                    Scene scene = new Scene(root, 600, 400); // Adjust width and height as needed
                    newStage.setTitle("Faculty Profile");

                    // Set the scene to the new stage and show it
                    newStage.setScene(scene);
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            contextMenu.getItems().addAll(viewStudents);

            cell.textProperty().bind(cell.itemProperty());

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell ;
        });

    }

}
