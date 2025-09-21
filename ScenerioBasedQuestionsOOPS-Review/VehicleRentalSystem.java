// Rentable interface
interface Rentable {
    double calculateRent(int days);
}

// Vehicle base class
class Vehicle {
    protected String brand;
    protected String model;
    protected double baseRate; // rate/day

    public Vehicle(String brand, String model, double baseRate) {
        this.brand = brand;
        this.model = model;
        this.baseRate = baseRate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + model + ", Rate: Rs." + baseRate + "/day");
    }
}

// Bike class
class Bike extends Vehicle implements Rentable {
    private boolean helmetIncluded;

    public Bike(String brand, String model, double baseRate, boolean helmetIncluded) {
        super(brand, model, baseRate);
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    public double calculateRent(int days) {
        double total = baseRate * days;
        if (!helmetIncluded) total += 10; // surcharge if helmet not included
        return total;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Helmet Included: " + helmetIncluded);
    }
}

// Car class
class Car extends Vehicle implements Rentable {
    private int seatCapacity;

    public Car(String brand, String model, double baseRate, int seatCapacity) {
        super(brand, model, baseRate);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public double calculateRent(int days) {
        double total = baseRate * days;
        if (seatCapacity > 5) total += 20; // surcharge for larger cars
        return total;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seats: " + seatCapacity);
    }
}

// Truck class
class Truck extends Vehicle implements Rentable {
    private double loadCapacity; // in tons

    public Truck(String brand, String model, double baseRate, double loadCapacity) {
        super(brand, model, baseRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRent(int days) {
        double total = baseRate * days;
        total += loadCapacity * 15; // surcharge based on load capacity
        return total;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Customer class
class Customer {
    private String name;
    private String contact;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void displayInfo() {
        System.out.println("Customer: " + name + ", Contact: " + contact);
    }
}

// Main class to test
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Customer c1 = new Customer("Raghav Gupta", "123-456-7890");

        Bike bike1 = new Bike("Yamaha", "FZ", 50, true);
        Car car1 = new Car("Toyota", "Trueno 86", 100, 5);
        Truck truck1 = new Truck("Tata", "LPT", 150, 10);

        c1.displayInfo();
        System.out.println();

        bike1.displayInfo();
        System.out.println("Bike Rent for 3 days: Rs." + bike1.calculateRent(3));
        System.out.println();

        car1.displayInfo();
        System.out.println("Car Rent for 5 days: Rs." + car1.calculateRent(5));
        System.out.println();

        truck1.displayInfo();
        System.out.println("Truck Rent for 4 days: Rs." + truck1.calculateRent(4));
    }
}
