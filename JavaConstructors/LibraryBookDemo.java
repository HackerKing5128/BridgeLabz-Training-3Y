class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price +
                ", Available: " + isAvailable);
    }
}

public class LibraryBookDemo {
    public static void main(String[] args) {
        LibraryBook lb = new LibraryBook("Data Structures", "Mark Allen", 350.0);
        lb.display();
        lb.borrowBook();
        lb.borrowBook();
        lb.display();
    }
}
