package com.example.engg1420facultymanagement;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    @FXML
    private ListView<String> facultyList;


    @FXML
    private Button addFacultyButton;

    @FXML
    void addFaculty(ActionEvent event) throws IOException {
        try {
            // Load the FXML for the Faculty-Profile.fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-faculty.fxml"));

            // Optionally, set a controller if needed
            //Controller profileController = new Controller();  // Adjust as necessary if you need a specific controller
            //fxmlLoader.setController(profileController); //TODO create controller

            // Load the scene from the FXML file
            Parent root = fxmlLoader.load();

            // Create a new stage (window)
            Stage newStage = new Stage();

            // Create a new scene and set it for the new stage
            Scene scene = new Scene(root, 600, 400); // Adjust width and height as needed
            newStage.setTitle("Add Faculty");

            // Set the scene to the new stage and show it
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        facultyList.getItems().addAll("One", "Two", "Three");

        facultyList.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();

            ContextMenu contextMenu = new ContextMenu();

            MenuItem editProfile = new MenuItem();
            editProfile.textProperty().bind(Bindings.format("View Profile for \"%s\"", cell.itemProperty()));
            editProfile.setOnAction(event -> {
                String item = cell.getItem();

                try {
                    // Load the FXML for the Faculty-Profile.fxml file
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("faculty-profile.fxml"));

                    FacultyProfileController profileController = new FacultyProfileController();
                    fxmlLoader.setController(profileController); //TODO create controller

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

            MenuItem deleteItem = new MenuItem();
            deleteItem.textProperty().bind(Bindings.format("Delete \"%s\"", cell.itemProperty()));
            deleteItem.setOnAction(event -> facultyList.getItems().remove(cell.getItem()));

            MenuItem assign_courses = new MenuItem();
            assign_courses.textProperty().bind(Bindings.format("Assign Courses to \"%s\"", cell.itemProperty()));
            assign_courses.setOnAction(event -> {
                String item = cell.getItem();

                try {
                    // Load the FXML for the Faculty-Profile.fxml file
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("assign-courses.fxml"));

                    // Optionally, set a controller if needed
                    //Controller profileController = new Controller();  // Adjust as necessary if you need a specific controller
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


            contextMenu.getItems().addAll(editProfile, deleteItem, assign_courses);

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