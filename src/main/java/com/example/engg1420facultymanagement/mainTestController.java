package com.example.engg1420facultymanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.sql.SQLException;

public class mainTestController {

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private VBox mainVBox;

    @FXML
    void initialize() throws SQLException, IOException {
        DatabaseManager db = new DatabaseManager("/home/user/test.db");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("faculty-overview.fxml"));
        fxmlLoader.setController(new facultyController(db, "admin", mainAnchorPane));
        AnchorPane pane = fxmlLoader.load();

        mainAnchorPane.getChildren().add(pane);




       /* Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Faculty Overview");
        stage.setScene(scene);
        stage.show();*/
    }

}
