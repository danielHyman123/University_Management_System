package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteCourseController {

    @FXML private Button deleteCourseButton; // Declare the button

    @FXML
    private void goBack() {
        Stage stage = (Stage) deleteCourseButton.getScene().getWindow();
        stage.close();  // Close the current window
    }
}
