package engg1420group2.universitymanagementsystem.studentmanagement;


import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.IOException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;



public class HelloController implements Initializable {
    @FXML
    private Label title_studentList;

    @FXML
    private ListView<String> studentList;
    @FXML
    private Button sceneSwitch;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void handleButton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("StudentInfo.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        /*

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("StudentInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();

         */
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        studentList.getItems().addAll("Kyle", "Daniel", "Achebe", "Anthony", "Mateo");
        title_studentList.setText("Student Management Update");

        HashMap<String, Student> studentHashMap = new HashMap<String, Student>();

        Student Ky = new Student("Kyle", "Address", "55555", "email@email.com", "Research" );
        Student Da = new Student("Daniel", "Address", "55555", "email@email.com", "Research" );
        Student Ac = new Student("Achebe", "Address", "55555", "email@email.com", "Research" );
        Student An = new Student("Anthony", "Address", "55555", "email@email.com", "Research" );
        Student Ma = new Student("Mateo", "Address", "55555", "email@email.com", "Research" );

        studentHashMap.put("Kyle", Ky);
        studentHashMap.put("Daniel", Da);
        studentHashMap.put("Achebe", Ac);
        studentHashMap.put("Anthony", An);
        studentHashMap.put("Mateo", Ma);



        /*
        databaseConnection connectNow = new databaseConnection();
        Connection connectDB = connectNow.getDBConnection();

        String connectQuery = "SELECT name, studentid FROM UMS_Data_Students";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()) {
                String name = queryOutput.getString("name");
                String username = queryOutput.getString("username");
                String listOut = name + username;
                studentList.getItems().add(listOut);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

         */



    }




}