import java.util.*;

// Product class
class Product {
    private String name;
    private double pricePerUnit;
    private double quantity;

    public Product(String name, double pricePerUnit, double quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return pricePerUnit * quantity;
    }
}

// Customer class
class Customer {
    private String name;
    private List<Product> products; // Composition: Customer owns Products

    public Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

// BillGenerator class
class BillGenerator {
    public double generateBill(Customer customer) {
        double total = 0;
        for (Product product : customer.getProducts()) {
            total += product.getTotalPrice();
        }
        return total;
    }
}

// Test class
public class GroceryStoreApp {
    public static void main(String[] args) {
        // Create customer and purchased products
        Customer customer = new Customer("Nakul");
        customer.addProduct(new Product("Apples", 30.0, 2.0));  // 2 kg at Rs30/kg
        customer.addProduct(new Product("Milk", 80.0, 1.0));    // 1 liter at Rs.80/liter

        // Generate bill
        BillGenerator billGenerator = new BillGenerator();
        double totalBill = billGenerator.generateBill(customer);

        // Output
        System.out.println("Customer: " + customer.getName());
        for (Product p : customer.getProducts()) {
            System.out.println(p.getName() + " -> " + p.getQuantity() + " units @ Rs."
                    + p.getPricePerUnit() + " each = Rs." + p.getTotalPrice());
        }
        System.out.println("Total Bill: Rs." + totalBill);
    }
}
