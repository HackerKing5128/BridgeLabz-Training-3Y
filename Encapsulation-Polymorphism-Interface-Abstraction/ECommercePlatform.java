// Interface for Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    // Method to display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Electronics class
class Electronics extends Product implements Taxable {
    private double warrantyDiscount;

    public Electronics(int productId, String name, double price, double warrantyDiscount) {
        super(productId, name, price);
        this.warrantyDiscount = warrantyDiscount;
    }

    @Override
    public double calculateDiscount() {
        return warrantyDiscount; // Flat discount for warranty
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied.";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    private double seasonalDiscount;

    public Clothing(int productId, String name, double price, double seasonalDiscount) {
        super(productId, name, price);
        this.seasonalDiscount = seasonalDiscount;
    }

    @Override
    public double calculateDiscount() {
        return seasonalDiscount; // Flat seasonal discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public String getTaxDetails() {
        return "5% VAT applied.";
    }
}

// Groceries class
class Groceries extends Product {
    private double bulkDiscount;

    public Groceries(int productId, String name, double price, double bulkDiscount) {
        super(productId, name, price);
        this.bulkDiscount = bulkDiscount;
    }

    @Override
    public double calculateDiscount() {
        return bulkDiscount; // Flat bulk discount
    }
}

// Main testing class
public class ECommercePlatform {
    public static void calculateFinalPrice(Product[] products) {
        for (Product p : products) {
            double discount = p.calculateDiscount();
            double tax = 0;

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                System.out.println(((Taxable) p).getTaxDetails());
            } else {
                System.out.println("No tax for this product.");
            }

            double finalPrice = p.getPrice() + tax - discount;
            p.displayDetails();
            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {
        Product[] products = new Product[3];

        products[0] = new Electronics(201, "Laptop", 50000, 2000);
        products[1] = new Clothing(202, "Jacket", 3000, 500);
        products[2] = new Groceries(203, "Rice Bag", 1200, 100);

        calculateFinalPrice(products);
    }
}
