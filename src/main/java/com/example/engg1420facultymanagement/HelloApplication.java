package com.example.engg1420facultymanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        DatabaseManager db = new DatabaseManager("/home/user/test.db");
        String access;
        /*List<String> faculty = db.getColumnValues("Students", "Student ID");
        for (String facultyName : faculty) {
            System.out.println("Faculty: " + facultyName);
        }*/
        String username = "admin";  //"F0001" ""S20250001";
        if(username.equals("admin")) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("faculty-overview.fxml"));
            fxmlLoader.setController(new facultyController(db, username));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Faculty Overview");
            stage.setScene(scene);
            stage.show();
        }else{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("faculty-profile.fxml"));
            if(db.belongsToTable("Faculties", username)){
                access = "faculty";
            }else if(db.belongsToTable("Students", username)){
                access = "student";
            }else{
                access = "student";
            }
            if(db.belongsToTable("Faculties", username)) {
                fxmlLoader.setController(new FacultyProfileController(username, access, db));
            }else{
                fxmlLoader.setController(new FacultyProfileController("F0001", access, db));

            }
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Faculty Profile");
            stage.setScene(scene);
            stage.show();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}