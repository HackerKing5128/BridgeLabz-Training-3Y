interface IDiscountable {
    double applyDiscount(double price);
}

// Base Book class
class Book implements IDiscountable {
    private String title;
    private String author;
    protected double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
        } else {
            System.out.println("Not enough stock available.");
        }
    }

    public String getTitle() {
        return title;
    }

    // Default discount = 0
    @Override
    public double applyDiscount(double price) {
        return price;
    }

    @Override
    public String toString() {
        return title + " by " + author + " - Rs." + price + " (Stock: " + stock + ")";
    }
}

// EBook subclass
class EBook extends Book {
    public EBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    // 20% discount for ebooks
    @Override
    public double applyDiscount(double price) {
        return price * 0.8;
    }
}

// PrintedBook subclass
class PrintedBook extends Book {
    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    // 10% discount for printed books
    @Override
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}

// Order class
class Order {
    private String user;
    private Book book;
    private int quantity;
    private double totalCost;
    private String status;

    public Order(String user, Book book, int quantity) {
        this.user = user;
        this.book = book;
        this.quantity = quantity;
        this.status = "Pending";
        calculateTotal();
        book.updateStock(quantity);
    }

    private void calculateTotal() {
        double basePrice = book.applyDiscount(book.price) * quantity;
        this.totalCost = basePrice;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void updateStatus(String newStatus) {
        if (newStatus.equals("Shipped") || newStatus.equals("Delivered") || newStatus.equals("Cancelled")) {
            this.status = newStatus;
        } else {
            System.out.println("Invalid status update.");
        }
    }

    @Override
    public String toString() {
        return "Order for " + user + ": " + quantity + " x " + book.getTitle() +
                " | Total: Rs." + totalCost + " | Status: " + status;
    }
}

// Demo
public class BookBazaar {
    public static void main(String[] args) {
        Book ebook = new EBook("Java Basics", "Johnny English", 200.0, 10);
        Book printed = new PrintedBook("OOP in Depth", "Gwen Stacy", 550.0, 5);

        System.out.println(ebook);
        System.out.println(printed);
        System.out.println();

        Order order1 = new Order("Yash", ebook, 2);
        System.out.println(order1);

        Order order2 = new Order("Troy", printed, 1);
        System.out.println(order2);

        // Update order status
        System.out.println();
        order1.updateStatus("Shipped");
        System.out.println(order1);
    }
}
