// GPS Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract Vehicle class
abstract class Vehicle implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    // GPS methods
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass Car
class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

// Subclass Bike
class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.8; // cheaper than car
    }
}

// Subclass Auto
class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return (distance * getRatePerKm()) + 20; // base fare added
    }
}

// Main testing class
public class RideHailingApp {
    // fare calculator method
    public static void processRide(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.println("Current Location: " + vehicle.getCurrentLocation());
        System.out.println("Fare for " + distance + " km: " + vehicle.calculateFare(distance));
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Vehicle car = new Car("C101", "yash", 15, "Downtown");
        Vehicle bike = new Bike("B202", "Raghav", 10, "Uptown");
        Vehicle auto = new Auto("A303", "Charlie", 12, "City Center");

        processRide(car, 10);
        processRide(bike, 10);
        processRide(auto, 10);

        // Updating GPS
        car.updateLocation("Airport");
        System.out.println("Car new location: " + car.getCurrentLocation());
    }
}
