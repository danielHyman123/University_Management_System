package com.example.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditCourseController {

    @FXML private Button editCourseButton;
    @FXML private Button goBackButton;

    @FXML
    private void goBack() {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();  // Close the current window
    }
}
