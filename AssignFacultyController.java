package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AssignFacultyController {

    @FXML private Button assignFacultyButton;
    @FXML private Button goBackButton;// on

    @FXML
    private void goBack() {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();  // Close the current window
    }
}