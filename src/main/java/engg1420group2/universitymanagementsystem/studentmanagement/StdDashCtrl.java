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



public class StdDashCtrl {
    DatabaseManager db;

   public StdDashCtrl(DatabaseManager db) {
       this.db = db;
   }

    @FXML
    private Label title_studentList;

    @FXML
    private ListView<String> listViewStudent;
    @FXML
    private Button button_testSwitchScene, button_addStd, button_deleteStd;


    private Stage stage;
    private Scene scene;
    private Parent root;

    //public static sharedDatabase db = new sharedDatabase();


    //View Student Button Script
    @FXML
    void viewStudent(ActionEvent event) throws IOException {
        try {

            Stage currentStage = (Stage) button_testSwitchScene.getScene().getWindow();
            Scene currentScene = currentStage.getScene();

            StdProfileViewCtrl stdProfileViewCtrl = new StdProfileViewCtrl(db);
            FXMLLoader fxmlLoader = new FXMLLoader(StdDashApp.class.getResource("StdViewProfile.fxml"));
            fxmlLoader.setController(stdProfileViewCtrl);

            Parent root = fxmlLoader.load();

            currentStage.setScene(new Scene(root, 600, 400));
            currentStage.setTitle("View Student Profile");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Edit Button Script
    @FXML
    void add(ActionEvent event) throws IOException {
        try {

            Stage currentStage = (Stage) button_addStd.getScene().getWindow();
            Scene currentScene = currentStage.getScene();

            StdCreateCtrl stdCreateCtrl = new StdCreateCtrl(db);
            FXMLLoader fxmlLoader = new FXMLLoader(StdDashApp.class.getResource("StdProfileAdd.fxml"));
            fxmlLoader.setController(stdCreateCtrl);

            Parent root = fxmlLoader.load();

            currentStage.setScene(new Scene(root, 600, 400));
            currentStage.setTitle("Add Student");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Delete Button Script
    @FXML
    void delete(ActionEvent event) throws IOException {
        listViewStudent.getItems().remove(listViewStudent.getSelectionModel().getSelectedIndex());

    }





    @FXML
    public void initialize() {


        //Populates the sample student list

        for(int i = 0; i < sharedDatabase.stdNameList.size(); i++){
            listViewStudent.getItems().add(sharedDatabase.stdNameList.get(i));
        }



        // Code of detecting what the user is selecting on the list
        // Add listener to ListView selection
        listViewStudent.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            sharedDatabase.setSelectedName(newValue);  // Save the selected name to SharedModel
        });


        //Creates the right click menu
        listViewStudent.setCellFactory(lv -> {

            ListCell<String> cell = new ListCell<>();

            ContextMenu contextMenu = new ContextMenu();

            //Creating the view option for the right click menu
            MenuItem viewProfile = new MenuItem();
            viewProfile.textProperty().bind(Bindings.format("View Profile for \"%s\"", cell.itemProperty()));
            viewProfile.setOnAction(event -> {
                String item = cell.getItem();

                //Sending to another screen
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(StdDashApp.class.getResource("StdViewProfile.fxml"));

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

            //Creating the edit profile option for the right-click menu
            MenuItem addProfile = new MenuItem();
            addProfile.textProperty().bind(Bindings.format("Edit Profile for \"%s\"", cell.itemProperty()));
            addProfile.setOnAction(event -> {
                String item = cell.getItem();

                //Loading the editing page
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(StdDashApp.class.getResource("StdProfileEditing.fxml"));

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

            //Creates the delete option for the right click menu
            MenuItem deleteItem = new MenuItem();
            deleteItem.textProperty().bind(Bindings.format("Delete \"%s\"", cell.itemProperty()));
            deleteItem.setOnAction(event -> listViewStudent.getItems().remove(cell.getItem()));

            //Adding all the options to the click down menu
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






