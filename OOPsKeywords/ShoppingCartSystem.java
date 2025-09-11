class Product {
    static double discount = 5.0;

    String productName;
    double price;
    int quantity;
    final int productID;

    public Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to " + discount + "%");
    }

    // Method to calculate total price after discount
    public double calculateTotalPrice() {
        double total = price * quantity;
        double discountedPrice = total - (total * discount / 100);
        return discountedPrice;
    }

    // Display product details with instanceof check
    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: Rs." + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Total Price after Discount: Rs." + calculateTotalPrice());
        }
    }
}

// Testing class
public class ShoppingCartSystem {
    public static void main(String[] args) {
        // Create product objects
        Product p1 = new Product("Laptop", 75000, 1, 101);
        Product p2 = new Product("Headphones", 3000, 2, 102);

        // Display product details
        p1.displayProductDetails();
        System.out.println("-------------------");
        p2.displayProductDetails();

        // Update discount (static)
        System.out.println("-------------------");
        Product.updateDiscount(10.0);

        // Display product details again with updated discount
        System.out.println("-------------------");
        p1.displayProductDetails();
        System.out.println("-------------------");
        p2.displayProductDetails();
    }
}
