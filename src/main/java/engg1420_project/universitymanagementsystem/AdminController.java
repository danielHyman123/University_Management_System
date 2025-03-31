package engg1420_project.universitymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AdminController extends User{

    @FXML
    private TextField eventNameField;
    @FXML
    private TextField eventCodeField;
    @FXML
    private TextField eventDescriptionField;
    @FXML
    private ImageView headerImageView;

    public AdminController(String userId, String name, String email, boolean isAdmin) {
        super(userId, name, email, isAdmin);
    }


    // Add Event
    @FXML
    private void addEvent() {
        String eventName = eventNameField.getText();
        String eventCode = eventCodeField.getText();
        String eventDescription = eventDescriptionField.getText();

        Event newEvent = new Event(eventName, eventCode, eventDescription, "default.jpg", "Location", 100, "cost");
        // Save the new event in a list or database

        showAlert("Event Added", "The event was successfully added.");
    }

    // Edit Event
    @FXML
    private void editEvent() {
        new EditEventController();
    }

    // Delete Event
    @FXML
    private void deleteEvent() {
        new DeleteEventController();
    }

    // View Events
    @FXML
    private void viewEvents() {
        new ViewEventsController();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}