package engg1420group2.universitymanagementsystem.studentmanagement;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;


public class StdProfileViewCtrl  {

    DatabaseManager db;
    String studentID;
    String access;

    public StdProfileViewCtrl(String studentID, String access, DatabaseManager db) {
        this.db = db;
        this.studentID = studentID;
        this.access = access;
    }

    @FXML
    private ListView<String> courseListView;

    @FXML
    private ListView<String> subjectListView;

    @FXML
    private Label labelStdName, labelStdID, labelStdEmail, labelStdPhone, labelStdAddress, labelSemester, labelAcmLvl, labelThesis;
    @FXML
    private Label labelTotalAmt, labelAmtPaid, labelAmtLeft;

    @FXML
    private ProgressBar barProgramProgress;

    @FXML
    public ImageView profilePhoto;


    @FXML
    private Button BtnExit;


    @FXML
    void exit (ActionEvent event) throws IOException {

    }

    @FXML
    public void initialize() {


    }
}
