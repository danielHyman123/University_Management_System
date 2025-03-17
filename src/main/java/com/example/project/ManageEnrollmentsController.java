package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ManageEnrollmentsController {

    @FXML private Label courseLabel;
    @FXML private TableView<Student> studentsTable;
    @FXML private TableColumn<Student, Integer> idColumn;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, String> addressColumn;
    @FXML private TableColumn<Student, String> phoneColumn;
    @FXML private TableColumn<Student, String> emailColumn;
    @FXML private TableColumn<Student, String> levelColumn;
    @FXML private TableColumn<Student, Integer> semesterColumn;
    @FXML private Button closeButton;

    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    public void setCourse(Course course) {
        courseLabel.setText("Enrolled Students in " + course.getCourseName());

        // **List is EMPTY now.**
        // Later, you’ll add the hardcoded students here.

        studentsTable.setItems(studentList);
    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
