package engg1420group2.universitymanagementsystem.studentmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class StdDashApp extends Application {
    DatabaseManager db = new DatabaseManager("C:/Users/egank/Downloads/UMdatabase.sqlite");

    //Determining the type of user, admin or other
    String user = "Admin";



//Starting Application Script
    //Opens the Student Dashboard Screen and sets the screen margins
    @Override
    public void start(Stage stage) throws IOException {

        if (user == "Admin") {
            FXMLLoader fxmlLoader = new FXMLLoader(StdDashApp.class.getResource("StdDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Student Management System (Admin View)");
            stage.setScene(scene);
            stage.show();

        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(StdDashApp.class.getResource("StdDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Student Management System");
            stage.setScene(scene);
            stage.show();

        }


    }

    public static void main(String[] args) {launch(); }
}