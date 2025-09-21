import java.util.*;
import java.time.LocalDateTime;

interface ISchedulable {
    void schedule();

    void reschedule(Date newDate);

    void cancel();
}

// User class
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void printDetails() {
        System.out.println("Organizer: " + name + ", Email: " + email);
    }
}

// Event base class
abstract class Event implements ISchedulable {
    private static int counter = 1000;
    private final int eventId;  // restricted
    protected String eventName;
    protected String location;
    protected Date date;
    protected List<String> attendees;
    private double baseCost;
    private double extraServices;
    private double discount;

    public Event(String eventName, String location, Date date, List<String> attendees, double baseCost) {
        this.eventId = ++counter;
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.baseCost = baseCost;
    }

    // Cost calculation
    public double calculateCost() {
        return (baseCost + extraServices) - discount;
    }


    public void addServices(double serviceCost) {
        this.extraServices += serviceCost;
    }

    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    public int getEventId() {
        return eventId;
    }

    public abstract void schedule();

    @Override
    public void reschedule(Date newDate) {
        this.date = newDate;
        System.out.println(eventName + " has been rescheduled to " + newDate);
    }

    @Override
    public void cancel() {
        System.out.println(eventName + " with ID " + eventId + " has been cancelled.");
    }

    public void printDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Name: " + eventName + ", Location: " + location + ", Date: " + date);
        System.out.println("Attendees: " + attendees);
        System.out.println("Total Cost: " + calculateCost());
    }
}

// Birthday Event
class BirthdayEvent extends Event {
    public BirthdayEvent(String name, String location, Date date, List<String> attendees, double baseCost) {
        super(name, location, date, attendees, baseCost);
    }

    @Override
    public void schedule() {
        System.out.println("Birthday event \"" + eventName + "\" scheduled at " + location + " on " + date);
    }
}

// Conference event
class ConferenceEvent extends Event {
    public ConferenceEvent(String name, String location, Date date, List<String> attendees, double baseCost) {
        super(name, location, date, attendees, baseCost);
    }

    @Override
    public void schedule() {
        System.out.println("Conference \"" + eventName + "\" scheduled at " + location + " on " + date);
    }
}

// Testing class
public class EventEase {
    public static void main(String[] args) {
        User organizer = new User("Nakul Saini", "nakul@tester.com");

        List<String> attendees = Arrays.asList("Yash", "Nayan", "Charlie");

        Event birthday = new BirthdayEvent("Yash's Birthday", "Banquet Hall", new Date(), attendees, 5000);
        birthday.addServices(2000);   // Decoration charge
        birthday.applyDiscount(500);  // Discount
        birthday.schedule();
        birthday.printDetails();

        System.out.println();

        Event conference = new ConferenceEvent("Tech Conference", "Auditorium", new Date(), attendees, 20000);
        conference.addServices(8000);  // Catering + Sound charges
        conference.schedule();

        LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
        conference.reschedule(java.sql.Timestamp.valueOf(tomorrow)); // rescheduled to tomorrow
        conference.printDetails();

        System.out.println();
        organizer.printDetails();
    }
}
