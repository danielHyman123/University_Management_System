package engg1420group2.universitymanagementsystem.studentmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class StdCreateCtrl {

    @FXML
    private TextField tfName, tfAddress, tfPhone, tfEmail;

    @FXML
    private Label label_ID;

    /*
    Buttons
     */

    //Save Changes Button
    @FXML
    void addStudent(ActionEvent event) {
        Student s = new Student(tfName.getText(), "default123", tfEmail.getText(), tfAddress.getText(), tfPhone.getText(),"Undergraduate", "Fall 2025", "Research", "50%");
        sharedDatabase.addStudent(s.getName(), s);

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
    @FXML
    void exit(ActionEvent event) {
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


}
