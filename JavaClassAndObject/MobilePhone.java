// MobilePhone class
class Mobile {
    // Attributes
    String brand;
    String model;
    double price;

    // Constructor
    Mobile(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display phone details
    void displayDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
    }
}

// Main class
public class MobilePhone {
    public static void main(String[] args) {
        // Create objects of MobilePhone
        Mobile phone1 = new Mobile("Samsung", "Galaxy S24", 79999.00);
        Mobile phone2 = new Mobile("Apple", "iPhone 15", 129999.00);

        // Display details
        phone1.displayDetails();
        System.out.println();
        phone2.displayDetails();
    }
}
