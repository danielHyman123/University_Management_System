package engg1420_project.universitymanagementsystem;

public class Event {
    private String eventName;
    private String eventCode;
    private String description;
    private String location;
    private String dateTime;
    private int capacity;
    private String cost;

    // Constructor
    public Event(String eventName, String eventCode, String description, String location, String dateTime, int capacity, String cost) {
        this.eventName = eventName;
        this.eventCode = eventCode;
        this.description = description;
        this.location = location;
        this.dateTime = dateTime;
        this.capacity = capacity;
        this.cost = cost;
    }

    // Getters and Setters
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
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            throw new IllegalArgumentException("Capacity must be a positive number.");
        }
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        if (cost != null && !cost.isEmpty()) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost cannot be empty.");
        }
    }

    @Override
    public String toString() {
        return eventName + " (" + eventCode + ")";
    }
}