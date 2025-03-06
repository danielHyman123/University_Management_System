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

public class EditController {

    @FXML
    private TextField tfName, tfAddress, tfPhone, tfEmail;

    @FXML
    private Label label_ID;

   sharedModel sm = new sharedModel();
    //private sharedModel sm;
    String target = sharedModel.getSelectedName();
    //private String target;


    @FXML
    void saveChanges(ActionEvent event) throws IOException {




        sm.getValueForKey(target).setName(tfName.getText());
        sm.getValueForKey(target).setAddress(tfAddress.getText());
        sm.getValueForKey(target).setPhone(tfPhone.getText());
        sm.getValueForKey(target).setEmail(tfEmail.getText());


        try {
          //  Student updatedStd = new Student(tfName.getText(),tfAddress.getText(), tfPhone.getText(), tfEmail.getText(),"Research", "Undergrad");
         //   sm.updatePerson(target, updatedStd);

            // Load the FXML for the Faculty-Profile.fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

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

    @FXML
    void exit(ActionEvent event) throws IOException {
        try {
            // Load the FXML for the Faculty-Profile.fxml file
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

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


        tfName.setText(sm.getValueForKey(target).getName());
        tfAddress.setText(sm.getValueForKey(target).getAddress());
        tfPhone.setText(sm.getValueForKey(target).getPhone());
        tfEmail.setText(sm.getValueForKey(target).getEmail());




    }

    /*
    public void initData(sharedModel dataStorage, String studentKey) {
        dataStorage = sm;
        studentKey = target;

        // Initialize the fields with the current values
        Student std = dataStorage.getValueForKey(studentKey);

        tfName.setText(std.getName());
        tfAddress.setText(std.getAddress());
        tfPhone.setText(std.getPhone());
        tfEmail.setText(std.getEmail());

    }

     */


}



