import java.util.*;

// Interface
interface IOrderable {
    void placeOrder();
    void cancelOrder();
}

// Base FoodItem class
class FoodItem {
    private String name;
    private String category;
    protected double price;
    private int stock;

    public FoodItem(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    public void reduceStock(int qty) {
        if (qty <= stock) {
            stock -= qty;
        } else {
            System.out.println("Not enough stock for " + name);
        }
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - Rs." + price + " | Stock: " + stock;
    }
}

// VegItem subclass
class VegItem extends FoodItem {
    public VegItem(String name, double price, int stock) {
        super(name, "Veg", price, stock);
    }
}

// NonVegItem subclass
class NonVegItem extends FoodItem {
    public NonVegItem(String name, double price, int stock) {
        super(name, "Non-Veg", price, stock);
    }
}

// Order class
class Order implements IOrderable {
    private List<FoodItem> items = new ArrayList<>();
    private double total;
    private String status;

    public Order() {
        this.status = "Created";
    }

    // combo meals
    public Order(List<FoodItem> comboItems) {
        this();
        this.items.addAll(comboItems);
        calculateTotal();
    }

    public void addItem(FoodItem item) {
        if (item.isAvailable()) {
            items.add(item);
            item.reduceStock(1);
            calculateTotal();
        } else {
            System.out.println(item.getName() + " is out of stock!");
        }
    }

    private void calculateTotal() {
        total = 0;
        for (FoodItem item : items) {
            total += item.getPrice();
        }
        total = applyDiscount(total);
    }

    protected double applyDiscount(double total) {
        if (total > 50) {
            return total * 0.9; // 10%
        } else if (total > 100) {
            return total * 0.8; // 20%
        }
        return total;
    }

    @Override
    public void placeOrder() {
        if (items.isEmpty()) {
            System.out.println("Cannot place an empty order!");
            return;
        }
        status = "Placed";
        System.out.println("Order placed successfully. Total: Rs." + String.format("%.2f", total));
    }

    @Override
    public void cancelOrder() {
        status = "Cancelled";
        System.out.println("Order cancelled.");
    }

    @Override
    public String toString() {
        return "Order: " + items.size() + " items | Total: Rs." + String.format("%.2f", total) + " | Status: " + status;
    }
}

// Testing class
public class FoodLoop {
    public static void main(String[] args) {
        FoodItem pizza = new VegItem("Margherita Pizza", 150.0, 5);
        FoodItem burger = new NonVegItem("Chicken Burger", 120.0, 3);
        FoodItem fries = new VegItem("French Fries", 88.0, 10);

        System.out.println(pizza);
        System.out.println(burger);
        System.out.println(fries);
        System.out.println();

        // Order
        Order order1 = new Order();
        order1.addItem(pizza);
        order1.addItem(burger);
        order1.addItem(fries);

        System.out.println(order1);

        order1.placeOrder();

        // Custom combo meal
        List<FoodItem> combo = new ArrayList<>();
        combo.add(pizza);
        combo.add(fries);

        Order comboOrder = new Order(combo);
        comboOrder.placeOrder();

        System.out.println(comboOrder);
    }
}
