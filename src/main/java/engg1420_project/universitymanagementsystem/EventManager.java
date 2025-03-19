package engg1420_project.universitymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    // Add a new event
    public void addEvent(Event event) {
        events.add(event);
    }

    // Delete an event by event code
    public boolean deleteEvent(String eventCode) {
        return events.removeIf(event -> event.getEventCode().equals(eventCode));
    }

    // Edit an existing event
    public boolean editEvent(String eventCode, Event updatedEvent) {
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.getEventCode().equals(eventCode)) {
                events.set(i, updatedEvent);
                return true;
            }
        }
        return false;
    }

    // View event by event code
    public Event viewEvent(String eventCode) {
        for (Event event : events) {
            if (event.getEventCode().equals(eventCode)) {
                return event;
            }
        }
        return null; // Event not found
    }

    // Get all events
    public List<Event> getAllEvents() {
        return events;
    }
}
