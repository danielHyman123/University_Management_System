package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handleLogin() {
        String role = checkLogin(); // Placeholder login check

        if (role.equals("Admin")) {
            switchToView("AdminView.fxml");
        } else if (role.equals("Faculty")) {
            switchToView("FacultyView.fxml");
        } else if (role.equals("Student")) {
            switchToView("StudentView.fxml");
        } else {
            System.exit(0);
        }
    }

    private String checkLogin() {
        // Placeholder: Replace with actual authentication logic
        return "Admin";
    }

    private void switchToView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/project/" + fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

