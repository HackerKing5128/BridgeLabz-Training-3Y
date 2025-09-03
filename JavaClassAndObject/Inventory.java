// Item class
class Item {
    // Attributes
    int itemCode;
    String itemName;
    double price;

    // Constructor
    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to calculate total cost
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    // Method to display item details
    void displayDetails(int quantity) {
        System.out.println("Item Details:");
        System.out.println("Code     : " + itemCode);
        System.out.println("Name     : " + itemName);
        System.out.println("Price    : " + price);
        System.out.println("Quantity : " + quantity);
        System.out.println("Total Cost: " + calculateTotalCost(quantity));
        System.out.println("----------------------------");
    }
}

// Main class
public class Inventory {
    public static void main(String[] args) {
        // Create Item object
        Item item1 = new Item(101, "Laptop", 55000.00);
        Item item2 = new Item(141, "Mobile", 35000.00);

        // Display details with quantity
        item1.displayDetails(2);
        item2.displayDetails(5);
    }
}
