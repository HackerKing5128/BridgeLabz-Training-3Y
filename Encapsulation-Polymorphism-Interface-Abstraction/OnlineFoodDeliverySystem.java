interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg item.";
    }
}

class NonVegItem extends FoodItem {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50; // extra charge for non-veg packaging
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg item.";
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    // method to process order
    public static void processOrder(FoodItem[] items) {
        double totalBill = 0;

        for (FoodItem item : items) {
            item.getItemDetails();
            double totalPrice = item.calculateTotalPrice();
            double discount = item.applyDiscount();
            double finalPrice = totalPrice - discount;

            System.out.println(item.getDiscountDetails());
            System.out.println("Total Price (before discount): " + totalPrice);
            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("---------------------------------");

            totalBill += finalPrice;
        }

        System.out.println("Grand Total for Order: " + totalBill);
    }

    public static void main(String[] args) {
        FoodItem[] order = new FoodItem[2];

        order[0] = new VegItem("Paneer Butter Masala", 200, 2);
        order[1] = new NonVegItem("Chicken Biryani", 300, 1);

        processOrder(order);
    }
}
