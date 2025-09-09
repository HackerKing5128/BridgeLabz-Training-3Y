class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 1000.0; // Example fixed rate

    // Default constructor
    CarRental() {
        this.customerName = "Unknown";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel +
                ", Days: " + rentalDays + ", Total Cost: " + calculateTotalCost());
    }
}

public class CarRentalDemo {
    public static void main(String[] args) {
        CarRental cr1 = new CarRental();
        CarRental cr2 = new CarRental("Charlie", "SUV", 5);

        cr1.display();
        cr2.display();
    }
}
