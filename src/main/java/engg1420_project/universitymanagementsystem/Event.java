package engg1420_project.universitymanagementsystem;

import java.util.List;
import java.util.ArrayList;

public class Event {
    private String eventName;
    private String eventCode;
    private String description;
    private String headerImage;
    private String location;
    private String dateTime;
    private int capacity;
    private double cost;
    private List<String> registeredStudents;

    public Event(String eventName, String eventCode, String description, String headerImage,
                 String location, String dateTime, int capacity, double cost) {
        this.eventName = eventName;
        this.eventCode = eventCode;
        this.description = description;
        this.headerImage = headerImage;
        this.location = location;
        this.dateTime = dateTime;
        this.capacity = capacity;
        this.cost = cost;
        this.registeredStudents = new ArrayList<>();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setRegisteredStudents(List<String> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public void addRegisteredStudent(String studentName) {
        if (this.registeredStudents.size() < this.capacity) {
            this.registeredStudents.add(studentName);
        } else {
            System.out.println("Event is full.");
        }
    }

    public List<String> getRegisteredStudents() {
        return registeredStudents;
    }
}
