package engg1420group2.universitymanagementsystem.studentmanagement;

import javafx.beans.Observable;
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

public class StdProfileEditCtrl  {

    DatabaseManager db;

    public StdProfileEditCtrl(DatabaseManager db) {
        this.db = db;
    }

    @FXML
    private TextField tfName, tfAddress, tfPhone, tfEmail, tfPassword, tfThesis;

    @FXML
    private Label labelStdID;

    @FXML
    private Button btnSave, btnExit, btnUpload;


    String target = sharedDatabase.getSelectedName();





    //Save changes button
    @FXML
    void saveChanges(ActionEvent event) throws IOException {

        //changing all the data to the values in the text field

        //Going back to the student dashboard
        try {
          //  Student updatedStd = new Student(tfName.getText(),tfAddress.getText(), tfPhone.getText(), tfEmail.getText(),"Research", "Undergrad");
         //   sm.updatePerson(target, updatedStd);

            // Load the FXML for the Faculty-Profile.fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(StdDashApp.class.getResource("StdDashboard.fxml"));

            // Load the scene from the FXML file
            Parent root = fxmlLoader.load();

            // Create a new stage (window)
            Stage newStage = new Stage();

            // Create a new scene and set it for the new stage
            Scene scene = new Scene(root, 600, 400); // Adjust width and height as needed
            newStage.setTitle("Student Management");

            // Set the scene to the new stage and show it
            newStage.setScene(scene);
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Exit Button
    //Goes back to the student dashboard without changing anything
    @FXML
    void exit(ActionEvent event) throws IOException {
        try {
            // Load the FXML for the Faculty-Profile.fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(StdDashApp.class.getResource("StdDashboard.fxml"));

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

    public void initialize() {

    //Filling the text fields with whats in the student object
        tfName.setText(sharedDatabase.getStudent(target).getName());
        tfAddress.setText(sharedDatabase.getStudent(target).getAddress());
        tfPhone.setText(sharedDatabase.getStudent(target).getPhone());
        tfEmail.setText(sharedDatabase.getStudent(target).getEmail());
        tfPassword.setText(sharedDatabase.getStudent(target).getPassword());
        tfThesis.setText(sharedDatabase.getStudent(target).getThesis());

        labelStdID.setText(sharedDatabase.getStudent(target).getStudentID());


    }



}



