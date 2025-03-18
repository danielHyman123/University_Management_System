package com.example.engg1420facultymanagement;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.SQLException;

public class FacultyProfileController {
    private boolean editable;
    private Faculty faculty;
    private DatabaseManager db;
    private Scene previousScene;
    private boolean isEditing = false;
    private boolean previous;

    public FacultyProfileController(String facultyInfo, String access, DatabaseManager db) throws SQLException {
        this.db = db;
        String[] parts = facultyInfo.split(":");
        this.faculty = new Faculty(parts[0], this.db);
        this.editable = !access.equals("student");
        if(access.equals("admin")) {
            previous = true;
        }else{
            previous = false;
        }
    }

    @FXML
    private Tab coursesTab;

    @FXML
    private Tab profileTab;

    @FXML
    private Button editButton;

    @FXML
    private ListView<String> coursesListView;

    @FXML
    private Label nameLabel, roomTextLabel, emailTextLabel;

    @FXML
    private Label researchTextLabel;

    @FXML
    private Label roomLabel, emailLabel, researchLabel;

    @FXML
    private TextField roomField, emailField, researchField;

    @FXML
    private Button backButton;

    @FXML
    private ImageView profileImage;

    @FXML
    private  TextField passwordText;

    @FXML
    private Button chooseImageButton;

    @FXML
    public void initialize() {
        passwordText.setText(faculty.getPassword());
        passwordText.setVisible(false);
        chooseImageButton.setVisible(false);
        backButton.setVisible(previous);
        profileTab.setClosable(false);

        coursesTab.setClosable(false);
        coursesTab.setDisable(!editable);

        System.out.println("Photo Location: " + faculty.getProfilePhotoLocation());

        System.out.println("Profile Photo Location: " + HelloApplication.class.getResource("images/" + faculty.getProfilePhotoLocation()));

        Image profile = new Image(HelloApplication.class.getResourceAsStream("images/" + faculty.getProfilePhotoLocation()));

        /*try{


            profileImage.setImage(profile);
        } catch (Exception e) {
            profileImage.setImage(new Image(HelloApplication.class.getResourceAsStream("images/profile.jpg")));
        }*/

        profileImage.setImage(profile);

        nameLabel.setText(faculty.getName());
        researchLabel.setText(faculty.getResearchInterest());
        roomLabel.setText(faculty.getOfficeLocation());
        emailLabel.setText(faculty.getEmail());

        roomField.setText(faculty.getOfficeLocation());
        emailField.setText(faculty.getEmail());
        researchField.setText(faculty.getResearchInterest());

        roomField.setVisible(false);
        emailField.setVisible(false);
        researchField.setVisible(false);

        editButton.setVisible(editable);

        coursesListView.getItems().addAll(faculty.getCourses().split(","));

        coursesListView.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<>();
            ContextMenu coursesMenu = new ContextMenu();

            MenuItem viewStudents = new MenuItem();
            viewStudents.textProperty().bind(Bindings.format("View students in \"%s\"", cell.itemProperty()));
            viewStudents.setOnAction(event -> openStudentsList(cell.getItem()));
            viewStudents.setDisable(!editable);

            coursesMenu.getItems().add(viewStudents);
            cell.textProperty().bind(cell.itemProperty());

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty) {
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(coursesMenu);
                }
            });

            return cell;
        });
    }

    @FXML
    private void toggleEdit(ActionEvent event) {
        if (!isEditing) {
            editButton.setText("Save");

            roomLabel.setVisible(false);
            emailLabel.setVisible(false);
            researchLabel.setVisible(false);

            roomField.setVisible(true);
            emailField.setVisible(true);
            researchField.setVisible(true);
            passwordText.setVisible(true);
            chooseImageButton.setVisible(true);
        } else {
            editButton.setText("Edit");

            roomLabel.setText(roomField.getText());
            emailLabel.setText(emailField.getText());
            researchLabel.setText(researchField.getText());

            faculty.setOfficeLocation(roomField.getText());
            faculty.setEmail(emailField.getText());
            faculty.setResearchInterest(researchField.getText());
            faculty.setPassword(passwordText.getText());

            faculty.updateInfo();

            roomLabel.setVisible(true);
            emailLabel.setVisible(true);
            researchLabel.setVisible(true);

            roomField.setVisible(false);
            emailField.setVisible(false);
            researchField.setVisible(false);
            passwordText.setVisible(false);
            chooseImageButton.setVisible(false);
        }

        isEditing = !isEditing;
    }

    @FXML
    private void goBack(ActionEvent event) {
        if (previousScene != null) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(previousScene);
        }
    }

    private void openStudentsList(String course) {
        try {
            Stage currentStage = (Stage) coursesListView.getScene().getWindow();
            Scene currentScene = currentStage.getScene();

            studentListController studentListController = new studentListController(db, currentScene, course);
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("students-list.fxml"));
            fxmlLoader.setController(studentListController);

            Parent root = fxmlLoader.load();

            currentStage.setScene(new Scene(root, 600, 400));
            currentStage.setTitle("Faculty Profile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void setPreviousScene(Scene previousScene) {
        this.previousScene = previousScene;
    }

    @FXML
    private void chooseImage(ActionEvent event) {
        try {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Profile Photo");
        File file = fileChooser.showOpenDialog((Stage) profileImage.getScene().getWindow());
        System.out.println(file.getName());


        File destination = null;
        
        URL resourceUrl = HelloApplication.class.getResource("images/");
        if (resourceUrl != null) {
            destination = new File(resourceUrl.toURI());
            if (destination.isDirectory()) {
                FileUtils.copyFileToDirectory(file, destination);
            } else {
                System.out.println("Destination is not a directory.");
            }
        } else {
            System.out.println("Resource path is null.");
        }

        //System.out.println(destination.getAbsolutePath());

        File newFile = new File(destination.getAbsolutePath() + "/" + file.getName() );

        //System.out.println(newFile.getAbsolutePath());
        faculty.setProfilePhotoLocation(newFile.getName());
        faculty.updateProfilePhoto();

        FileInputStream imageFile = new FileInputStream(newFile);

        Image image = new Image(imageFile);
        profileImage.setImage(image);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


    }
}