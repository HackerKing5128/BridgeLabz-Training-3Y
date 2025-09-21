// IRideService interface
interface IRideService {
    void bookRide(String pickup, String drop, double distance);

    void endRide();
}

// Vehicle base class
abstract class Vehicle {
    protected String vehicleNumber;
    protected int capacity;
    protected String type;
    private double fare;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
        this.fare = 0;
    }

    public double getFare() {
        return fare;
    }

    protected void setFare(double fare) {
        this.fare = fare;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public abstract void displayInfo();
}

// Mini vehicle class
class Mini extends Vehicle implements IRideService {
    private double ratePerKm = 10;

    public Mini(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Mini");
    }

    @Override
    public void bookRide(String pickup, String drop, double distance) {
        double baseFare = 50;
        double totalFare = baseFare + distance * ratePerKm;
        setFare(totalFare);
        System.out.println("Mini booked from " + pickup + " to " + drop + ". Fare: Rs." + totalFare);
    }

    @Override
    public void endRide() {
        System.out.println("Mini ride ended. Fare charged: Rs." + getFare());
    }

    @Override
    public void displayInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Capacity: " + capacity);
    }
}

// Sedan vehicle
class Sedan extends Vehicle implements IRideService {
    private double ratePerKm = 15;

    public Sedan(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Sedan");
    }

    @Override
    public void bookRide(String pickup, String drop, double distance) {
        double baseFare = 75;
        double totalFare = baseFare + distance * ratePerKm;
        setFare(totalFare);
        System.out.println("Sedan booked from " + pickup + " to " + drop + ". Fare: Rs." + totalFare);
    }

    @Override
    public void endRide() {
        System.out.println("Sedan ride ended. Fare charged: Rs." + getFare());
    }

    @Override
    public void displayInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Capacity: " + capacity);
    }
}

// SUV vehicle
class SUV extends Vehicle implements IRideService {
    private double ratePerKm = 20;

    public SUV(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "SUV");
    }

    @Override
    public void bookRide(String pickup, String drop, double distance) {
        double baseFare = 100;
        double totalFare = baseFare + distance * ratePerKm;
        setFare(totalFare);
        System.out.println("SUV booked from " + pickup + " to " + drop + ". Fare: Rs." + totalFare);
    }

    @Override
    public void endRide() {
        System.out.println("SUV ride ended. Fare charged: Rs." + getFare());
    }

    @Override
    public void displayInfo() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Capacity: " + capacity);
    }
}

// Driver class
class Driver {
    private String name;
    private String licenseNumber;
    private double rating;

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getRating() {
        return rating;
    }

    public void displayInfo() {
        System.out.println("Driver: " + name + ", License: " + licenseNumber + ", Rating: " + rating);
    }
}

// Main testing class
public class CabbyGoApp {
    public static void main(String[] args) {
        Driver d1 = new Driver("Himanshu", "LIC12345", 4.9);
        d1.displayInfo();
        System.out.println();

        Vehicle v1 = new Mini("UP12AB1234", 4);
        Vehicle v2 = new Sedan("MH12CD5678", 4);
        Vehicle v3 = new SUV("DL12EF9101", 6);

        v1.displayInfo();
        ((IRideService) v1).bookRide("Downtown", "Airport", 12);
        ((IRideService) v1).endRide();
        System.out.println();

        v2.displayInfo();
        ((IRideService) v2).bookRide("Mall", "Station", 8);
        ((IRideService) v2).endRide();
        System.out.println();

        v3.displayInfo();
        ((IRideService) v3).bookRide("Home", "Office", 15);
        ((IRideService) v3).endRide();
        System.out.println();
    }
}
