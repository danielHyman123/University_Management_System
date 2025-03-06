package com.example.engg1420facultymanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        DatabaseManager db = new DatabaseManager("/home/user/test.db");
        List<String> faculty = db.getColumnValues("Faculties", "Faculty ID");
        for (String facultyName : faculty) {
            System.out.println("Faculty: " + facultyName);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("faculty-overview.fxml"));
        fxmlLoader.setController(new facultyController(db));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}