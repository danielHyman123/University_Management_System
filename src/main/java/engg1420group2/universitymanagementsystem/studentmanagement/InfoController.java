package engg1420group2.universitymanagementsystem.studentmanagement;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.HashMap;

public class InfoController implements Initializable {

    @FXML
    private Label label_studentName, label_studentid, label_address, label_phone, label_email;

    HashMap<String, Student> studentHashMap = new HashMap<String, Student>();

    Student Ky = new Student("Kyle", "Address", "55555", "email@email.com", "Research" );
    Student Da = new Student("Daniel", "Address", "55555", "email@email.com", "Research" );
    Student Ac = new Student("Achebe", "Address", "55555", "email@email.com", "Research" );
    Student An = new Student("Anthony", "Address", "55555", "email@email.com", "Research" );
    Student Ma = new Student("Mateo", "Address", "55555", "email@email.com", "Research" );


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        studentHashMap.put("Kyle", Ky);
        studentHashMap.put("Daniel", Da);
        studentHashMap.put("Achebe", Ac);
        studentHashMap.put("Anthony", An);
        studentHashMap.put("Mateo", Ma);




    }






}
