package com.example.engg1420facultymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class assignCoursesController {

    private DatabaseManager db;
    private Scene previousScene;
    private String facultyID;
    private Faculty faculty;

    public assignCoursesController(DatabaseManager db, Scene previousScene, String facultyID) {
        this.db = db;
        this.previousScene = previousScene;
        this.facultyID = facultyID;
        try {
            this.faculty = new Faculty(facultyID, db);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private ListView<CheckBox> courseListView;  // ListView to hold CheckBox elements


    @FXML
    public void initialize() throws SQLException {
        // Get list of course names from the database
        List<String> courses = db.getColumnValues("Courses", "Course Name");

        // Get the list of courses already assigned to the faculty
        String assignedCourses = faculty.getCourses(); // Assuming this returns a string like "course1,course2,course3"

        // Split the assigned courses string into a list of course names
        List<String> assignedCoursesList = Arrays.asList(assignedCourses.split(","));

        // Create an observable list of CheckBox elements
        ObservableList<CheckBox> checkBoxes = FXCollections.observableArrayList();

        // Add a CheckBox for each course
        for (String course : courses) {
            CheckBox checkBox = new CheckBox(course);

            // Check if the course is already assigned to the faculty
            if (assignedCoursesList.contains(course)) {
                checkBox.setSelected(true); // Pre-check the checkbox if the course is already assigned
            }

            checkBoxes.add(checkBox);
        }

        // Set the items of the ListView to the list of CheckBoxes
        courseListView.setItems(checkBoxes);
    }

    @FXML
    private void save(ActionEvent event) {

        ObservableList<CheckBox> selectedCourses = courseListView.getItems();
        List<String> courses = new ArrayList<>();
        for (CheckBox checkBox : selectedCourses) {
            if (checkBox.isSelected()) {
                // Save the selected course
                courses.add(checkBox.getText());
            }
        }

        faculty.addCourses(courses);
        faculty.updateInfo();

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
