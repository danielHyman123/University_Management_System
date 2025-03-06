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


public class InfoController  {

    @FXML
    private ListView<String> courseListView;


    @FXML
    private Label label_studentName, label_studentid, label_address, label_phone, label_email;

    HashMap<String, Student> studentHashMap = new HashMap<String, Student>();

    Student Ky = new Student("Kyle", "545 Happy Street", "911", "Kyle@gmail.com", "Research", "Undergrad" );
    Student Da = new Student("Daniel", "222 Less Happy Cresent", "226-500-1567", "DannyH@hotmail.com", "Research", "Undergrad" );
    Student Ac = new Student("Achebe", "535 Normal Road", "519-232-4532", "Achebe123@gmail.com", "Research", "Undergrad" );
    Student An = new Student("Anthony", "1 Upset Street", "519-243-5343", "AntAnthony@gmail.com", "Research", "Undergrad" );
    Student Ma = new Student("Mateo", "45 Angry Road", "226-345-0987", "Mateo@gmail.com", "Research", "Undergrad" );


    @FXML
    public void initialize() {

        courseListView.getItems().addAll("ENGG 1500", "ENGG 1420", "ENGG 1210", "MATH 1210", "PHYS 1010");


        String target = sharedModel.getSelectedName();
        studentHashMap.put("Kyle", Ky);
        studentHashMap.put("Daniel", Da);
        studentHashMap.put("Achebe", Ac);
        studentHashMap.put("Anthony", An);
        studentHashMap.put("Mateo", Ma);

        label_studentName.setText(studentHashMap.get(target).getName());
        //label_studentid.setText(studentHashMap.get(target).getId());
        label_address.setText(studentHashMap.get(target).getAddress());
       // label_phone.setText(studentHashMap.get(target).getPhone());
        label_email.setText(studentHashMap.get(target).getEmail());

    }

    @FXML
    void management(ActionEvent event) throws IOException {
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






}
