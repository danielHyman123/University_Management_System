package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteCourseController {

    @FXML private Button deleteCourseButton;
    @FXML private Button goBackButton;

    @FXML
    private void goBack() {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();  // Close the current window
    }
}
