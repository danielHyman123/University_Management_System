package com.example.engg1420facultymanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentListController {

    private DatabaseManager db;
    private Scene previousScene;
    String course;

    public studentListController(DatabaseManager db, Scene previousScene, String course) {
        this.db = db;
        this.previousScene = previousScene;
        this.course = course;
        System.out.println("Course: " + course);
    }


    @FXML
    private ListView studentsList;

    @FXML
    private Button backButton;

    @FXML
    private void initialize() throws SQLException {

        this.course = this.course.replace("Intro", "Introduction");
        System.out.println("Course: " + course);

        String[] columns = {"Subject Code"};
        List<String> course_code = db.getFilteredValues("Courses", columns, "Course Name", course);
        List<String> students = db.getColumnValuesByFilter("Students", "Name", "Subjects Registered", course_code.get(0));
        List<String> student_ID = db.getColumnValuesByFilter("Students", "Student ID", "Subjects Registered", course_code.get(0));
        List<String> values = new ArrayList<>();

        for(int i = 0; i < students.size(); i++){
            values.add(student_ID.get(i) + ":" + students.get(i));
        }

        studentsList.getItems().addAll(values);
    }

    @FXML
    void goBack(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene);
        }
    }






}
