package engg1420group2.universitymanagementsystem.studentmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class StdCreateCtrl {

    DatabaseManager db;

    public StdCreateCtrl(DatabaseManager db) {
        this.db = db;
    }

    @FXML
    private TextField tfName, tfAddress, tfPhone, tfEmail;

    @FXML
    private Label label_ID;


    //Save Changes Button
    @FXML
    void addStudent(ActionEvent event) {

    }

    //Exit Button
    @FXML
    void exit(ActionEvent event) {

    }




}
