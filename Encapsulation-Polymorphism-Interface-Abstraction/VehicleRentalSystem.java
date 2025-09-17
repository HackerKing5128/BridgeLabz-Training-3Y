// Interface for Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Policy number kept private (mask it for safety)
    protected String getMaskedPolicyNumber() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    public abstract double calculateRentalCost(int days);

    // Display vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate (per day): " + rentalRate);
    }
}

// Car class
class Car extends Vehicle {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance, Policy: " + getMaskedPolicyNumber();
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) * 0.9; // 10% discount for bikes
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance, Policy: " + getMaskedPolicyNumber();
    }
}

// Truck class
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500; // extra maintenance charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance, Policy: " + getMaskedPolicyNumber();
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("CAR101", 2000, "P123456"); // assumed policy number
        vehicles[1] = new Bike("BIKE202", 500, "P654321");
        vehicles[2] = new Truck("TRUCK303", 5000, "P112233");

        // Polymorphism: iterate over vehicles
        for (Vehicle v : vehicles) {
            v.displayDetails();
            int days = 5;
            double rentalCost = v.calculateRentalCost(days);
            double insuranceCost = v.calculateInsurance();

            System.out.println("Rental Cost for " + days + " days: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Insurance Details: " + v.getInsuranceDetails());
            System.out.println("--------------------------------");
        }
    }
}
