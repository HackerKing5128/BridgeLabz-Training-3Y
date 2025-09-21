import java.util.*;

interface ICheckout {
    void generateBill();

    void applyDiscount(String couponCode);
}

// Product base class
class Product {
    protected String name;
    protected double price;
    protected String category;
    protected int quantity;

    public Product(String name, double price, String category, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    // discount differs by product type
    public double getDiscount() {
        return 0; // default - no discount
    }
}

// Perishable product
class PerishableProduct extends Product {
    public PerishableProduct(String name, double price, int quantity) {
        super(name, price, "Perishable", quantity);
    }

    @Override
    public double getDiscount() {
        return 0.10; // 10%
    }
}

// Non-Perishable product
class NonPerishableProduct extends Product {
    public NonPerishableProduct(String name, double price, int quantity) {
        super(name, price, "Non-Perishable", quantity);
    }

    @Override
    public double getDiscount() {
        return 0.05; // 5%
    }
}


// Cart class
class Cart implements ICheckout {
    private List<Product> products;
    private double totalPrice;
    private double discountApplied;

    // Empty cart
    public Cart() {
        this.products = new ArrayList<>();
        this.totalPrice = 0;
        this.discountApplied = 0;
    }

    // Cart with pre-selected items
    public Cart(List<Product> initialProducts) {
        this();
        for (Product p : initialProducts) {
            addProduct(p);
        }
    }

    private void updateTotalPrice() {
        totalPrice = 0;
        for (Product p : products) {
            double productTotal = p.getPrice() * p.getQuantity();
            double productDiscount = productTotal * p.getDiscount();
            totalPrice += (productTotal - productDiscount);
        }
        totalPrice -= discountApplied;
    }

    public void addProduct(Product p) {
        products.add(p);
        updateTotalPrice();
    }

    public void removeProduct(Product p) {
        products.remove(p);
        updateTotalPrice();
    }

    @Override
    public void generateBill() {
        System.out.println("----- SwiftCart Bill -----");
        for (Product p : products) {
            System.out.println(p.getName() + " (" + p.getCategory() + ") x" + p.getQuantity() +
                    " : " + p.getPrice() + " each");
        }
        System.out.println("Discounts Applied: " + discountApplied);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("--------------------------");
    }

    @Override
    public void applyDiscount(String couponCode) {
        if (couponCode.equals("SAVE50")) {
            discountApplied = 50; // Rs. 50 off
        } else if (couponCode.equals("SAVE10")) {
            discountApplied = totalPrice * 0.10; // 10% off
        } else {
            discountApplied = 0;
            System.out.println("Invalid coupon.");
        }
        updateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

// testing class
public class SwiftCartApp {
    public static void main(String[] args) {
        Product apple = new PerishableProduct("Apple", 40, 2);
        Product rice = new NonPerishableProduct("Rice Bag", 500, 1);
        Product milk = new PerishableProduct("Milk", 50, 3);

        Cart cart = new Cart();
        cart.addProduct(apple);
        cart.addProduct(rice);
        cart.addProduct(milk);

        // Apply coupon
        cart.applyDiscount("SAVE50");

        cart.generateBill();
    }
}
