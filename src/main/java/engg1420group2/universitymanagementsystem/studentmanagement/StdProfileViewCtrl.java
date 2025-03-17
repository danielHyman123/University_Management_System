package engg1420group2.universitymanagementsystem.studentmanagement;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;


public class StdProfileViewCtrl  {



    @FXML
    private ListView<String> courseListView;
    private ListView<String> subjectListView;

    @FXML
    private Label labelStdName, labelStdID, labelStdEmail, labelStdPhone, labelStdAddress, labelSemester, labelAcmLvl, labelThesis;
    private Label labelTotalAmt, labelAmtPaid, labelAmtLeft;

    @FXML
    private ProgressBar barProgramProgress;

    @FXML
    private ImageView imageProfile;


    @FXML
    private Button BtnExit;


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

    @FXML
    void leave (ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StdDashboard.fxml"));
        Stage window = (Stage) BtnExit.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

    @FXML
    public void initialize() {

        courseListView.getItems().addAll("ENGG 1500", "ENGG 1420", "ENGG 1210", "MATH 1210", "PHYS 1010");
        subjectListView.getItems().addAll("Engineering", "Math", "Physics", "Programming", "Chemistry");


        //Reads what cell is selected and sets it as a string
        String target = sharedDatabase.getSelectedName();

        //Accesses the student object connected to the key string
        //Sets all the labels to fill the main information

        labelStdName.setText(sharedDatabase.getStudent(target).getName());
        labelStdID.setText(sharedDatabase.getStudent(target).getStudentID());
        labelStdEmail.setText(sharedDatabase.getStudent(target).getEmail());
        labelStdPhone.setText(sharedDatabase.getStudent(target).getPhone());
        labelStdAddress.setText(sharedDatabase.getStudent(target).getAddress());
        labelSemester.setText(sharedDatabase.getStudent(target).getSemester());
        labelAcmLvl.setText(sharedDatabase.getStudent(target).getAcdemicLvl());
        labelThesis.setText(sharedDatabase.getStudent(target).getThesis());






    }
}
