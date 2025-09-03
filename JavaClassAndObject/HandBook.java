// Book class
class Book {
    // Attributes
    String title;
    String author;
    double price;

    // Constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
    }
}

// Main class
public class HandBook {
    public static void main(String[] args) {
        // Create Book object
        Book book1 = new Book("The Alchemist", "Paulo Coelho", 399.50);
        Book book2 = new Book("Wings Of Fire", "A.P.J. Abdul kalam", 500);
        // Display details
        book1.displayDetails();
        book2.displayDetails();
    }
}
