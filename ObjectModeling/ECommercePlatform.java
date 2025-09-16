import java.util.*;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayProduct() {
        System.out.println("  Product: " + name + " | Price: Rs." + price);
    }
}

// Order class (Aggregation: contains multiple Products)
class Order {
    private static int idCounter = 1;
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer) {
        this.orderId = idCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    // Add product to order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Show order details
    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customer.getName());
        double total = 0;
        for (Product p : products) {
            p.displayProduct();
            total += p.getPrice();
        }
        System.out.println("  Total Amount: Rs." + total + "\n");
    }
}

// Customer class (places Orders)
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Place new order
    public Order placeOrder() {
        Order order = new Order(this);
        orders.add(order);
        System.out.println(name + " placed a new order (ID: " + order.hashCode() + ")");
        return order;
    }

    // View all orders
    public void viewOrders() {
        System.out.println("Customer: " + name + " - Orders:");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

// testing class
public class ECommercePlatform {
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product("Laptop", 800);
        Product p2 = new Product("Headphones", 50);
        Product p3 = new Product("Smartphone", 600);

        // Create customers
        Customer c1 = new Customer("Henry");
        Customer c2 = new Customer("Charlie");

        // Customers placing orders
        Order o1 = c1.placeOrder();
        o1.addProduct(p1);
        o1.addProduct(p2);

        Order o2 = c2.placeOrder();
        o2.addProduct(p3);

        Order o3 = c1.placeOrder();
        o3.addProduct(p2);
        o3.addProduct(p3);

        // View orders
        c1.viewOrders();
        c2.viewOrders();
    }
}
