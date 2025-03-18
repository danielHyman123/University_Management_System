package engg1420group2.universitymanagementsystem.studentmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class StdCreateCtrl {

    DatabaseManager db;
    Scene previousScene;

    public StdCreateCtrl(Scene previousScene, DatabaseManager db) {
        this.db = db;
        this.previousScene = previousScene;
    }

    @FXML
    private TextField tfName, tfAddress, tfPhone, tfEmail, tfPassword, tfProgress, tfThesis;

    @FXML
    private Label label_ID;


    //Save Changes Button
    @FXML
    void addStudent(ActionEvent event) {
        //Still need to figure out the subject/courses, student ID & photo
        String[] student = new String[11];

        student[1] = tfName.getText();
        student[2] = tfAddress.getText();
        student[3] = tfPhone.getText();
        student[4] = tfEmail.getText();
        student[9] = tfThesis.getText();
        student[10] = tfProgress.getText();
        student[11] = tfPassword.getText();

        try {
            db.addRowToTable("UMS_Data_Students", student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene);
        }

    }

    //Exit Button
    @FXML
    void exit(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene);
        }

    }






}
