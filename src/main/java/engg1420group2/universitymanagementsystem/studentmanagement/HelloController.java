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
    private Button button_testSwitchScene;
    private Button button_addStd;
    private Button button_deleteStd;

    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    void student(ActionEvent event) throws IOException {
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

            MenuItem editProfile = new MenuItem();
            editProfile.textProperty().bind(Bindings.format("View Profile for \"%s\"", cell.itemProperty()));
            editProfile.setOnAction(event -> {
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


            contextMenu.getItems().add(editProfile);

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






