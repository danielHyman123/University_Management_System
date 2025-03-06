package engg1420group2.universitymanagementsystem.studentmanagement;


import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;



public class HelloController {
    @FXML
    private Label title_studentList;

    @FXML
    private ListView<String> studentList;
    @FXML
    private Button button_testSwitchScene, button_addStd, button_deleteStd;


    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    void viewStudent(ActionEvent event) throws IOException {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StudentInfo.fxml"));


            // Load the scene from the FXML file
            Parent root = fxmlLoader.load();

            // Create a new stage (window)
            Stage newStage = new Stage();

            // Create a new scene and set it for the new stage
            Scene scene = new Scene(root, 600, 400); // Adjust width and height as needed
            newStage.setTitle("Student Information");

            // Set the scene to the new stage and show it
            newStage.setScene(scene);
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void addOrEdit(ActionEvent event) throws IOException {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddStudent.fxml"));

            // Load the scene from the FXML file
            Parent root = fxmlLoader.load();

            // Create a new stage (window)
            Stage newStage = new Stage();

            // Create a new scene and set it for the new stage
            Scene scene = new Scene(root, 600, 400); // Adjust width and height as needed
            newStage.setTitle("Edit/Add Student Information");

            // Set the scene to the new stage and show it
            newStage.setScene(scene);
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void buttom_delete(ActionEvent event) throws IOException {
        studentList.getItems().remove(studentList.getSelectionModel().getSelectedIndex());

    }



    @FXML
    public void initialize() {

        studentList.getItems().addAll("Kyle", "Daniel", "Achebe", "Anthony", "Mateo");
        title_studentList.setText("Student Management Update");


        // Add listener to ListView selection
        studentList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            sharedModel.setSelectedName(newValue);  // Save the selected name to SharedModel
        });



        /*
        databaseConnection connectNow = new databaseConnection();
        Connection connectDB = connectNow.getDBConnection();

        String connectQuery = "SELECT name, studentid FROM UMS_Data_Students";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                String name = queryOutput.getString("name");
                String username = queryOutput.getString("username");
                String listOut = name + username;
                studentList.getItems().add(listOut);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

         */

        studentList.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();

            ContextMenu contextMenu = new ContextMenu();

            MenuItem viewProfile = new MenuItem();
            viewProfile.textProperty().bind(Bindings.format("View Profile for \"%s\"", cell.itemProperty()));
            viewProfile.setOnAction(event -> {
                String item = cell.getItem();

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StudentInfo.fxml"));

                    // Load the scene from the FXML file
                    Parent root = fxmlLoader.load();

                    // Create a new stage (window)
                    Stage newStage = new Stage();

                    // Create a new scene and set it for the new stage
                    Scene scene = new Scene(root, 600, 400); // Adjust width and height as needed
                    newStage.setTitle("Student Information");

                    // Set the scene to the new stage and show it
                    newStage.setScene(scene);
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            MenuItem addProfile = new MenuItem();
            addProfile.textProperty().bind(Bindings.format("Edit Profile for \"%s\"", cell.itemProperty()));
            addProfile.setOnAction(event -> {
                String item = cell.getItem();

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddStudent.fxml"));

                    // Load the scene from the FXML file
                    Parent root = fxmlLoader.load();

                    // Create a new stage (window)
                    Stage newStage = new Stage();

                    // Create a new scene and set it for the new stage
                    Scene scene = new Scene(root, 600, 400); // Adjust width and height as needed
                    newStage.setTitle("Add/Edit Profile");

                    // Set the scene to the new stage and show it
                    newStage.setScene(scene);
                    newStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            MenuItem deleteItem = new MenuItem();
            deleteItem.textProperty().bind(Bindings.format("Delete \"%s\"", cell.itemProperty()));
            deleteItem.setOnAction(event -> studentList.getItems().remove(cell.getItem()));


            contextMenu.getItems().addAll(viewProfile, deleteItem, addProfile);

            cell.textProperty().bind(cell.itemProperty());

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });
            return cell;
            });

    }
}






