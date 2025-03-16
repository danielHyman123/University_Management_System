package com.example.engg1420facultymanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class addFacultyController {
    private Scene previousScene;
    private DatabaseManager db;

    public addFacultyController(Scene prevtiousScene, DatabaseManager db) {
        this.previousScene = prevtiousScene;
        this.db = db;
    }

    @FXML
    private TextField facultyIdField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField degreeField;

    @FXML
    private TextField researchInterestField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField officeLocationField;

    @FXML
    private TextField coursesOfferedField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    // Initialize method or other handlers can be defined here
    @FXML
    public void initialize() {

    }

    @FXML
    private void save(ActionEvent event) {
        String[] faculty = new String[8];

        faculty[0] = facultyIdField.getText();
        faculty[1] = nameField.getText();
        faculty[2] = degreeField.getText();
        faculty[3] = researchInterestField.getText();
        faculty[4] = emailField.getText();
        faculty[5] = officeLocationField.getText();
        faculty[6] = coursesOfferedField.getText();
        faculty[7] = passwordField.getText();

        try {
            db.addRowToTable("Faculties", faculty);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene);
        }

    }

    @FXML
    private void cancel(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene);
        }
    }
}