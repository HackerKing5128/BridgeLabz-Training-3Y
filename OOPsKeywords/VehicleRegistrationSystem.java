class Vehicle {
    static double registrationFee = 5000.0; // default fee

    String ownerName;
    String vehicleType;
    final String registrationNumber;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration Fee updated to: Rs." + registrationFee);
    }

    // Display vehicle details (with instanceof check)
    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: Rs." + registrationFee);
        }
    }
}

// Testing class
public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        // Create vehicle objects
        Vehicle v1 = new Vehicle("Arjun Mehta", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("Sneha Kapoor", "Bike", "DL05XY5678");

        // Display registration details
        v1.displayRegistrationDetails();
        System.out.println("--------------------");
        v2.displayRegistrationDetails();

        // Update registration fee
        System.out.println("--------------------");
        Vehicle.updateRegistrationFee(6000.0);

        // Display details again after fee update
        System.out.println("--------------------");
        v1.displayRegistrationDetails();
        System.out.println("--------------------");
        v2.displayRegistrationDetails();
    }
}
