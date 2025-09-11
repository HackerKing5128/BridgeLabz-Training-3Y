class Book {
    static String libraryName = "Central City Library";

    String title;
    String author;
    final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details using instanceof
    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
}


public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book.displayLibraryName();
        System.out.println("------------------");

        // Create Book objects
        Book b1 = new Book("The Alchemist", "Paulo Coelho", "ISBN001");
        Book b2 = new Book("1984", "George Orwell", "ISBN002");

        // Display book details
        b1.displayBookDetails();
        System.out.println("------------------");
        b2.displayBookDetails();
    }
}
