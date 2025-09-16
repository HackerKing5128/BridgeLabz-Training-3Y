import java.util.*;

// Book class
class Book {
    private String title;
    private String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    //Display book
    public void displayBook() {
        System.out.printf("Title: %s, Author: %s\n", title, author);
    }
}

// Library class
class Library {
    private String name;
    private List<Book> books;

    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    //add book to this library
    public void addBook(Book book) {
        books.add(book);
    }

    // display all books
    public void showLibraryBooks() {
        System.out.println("Library: " + name);
        for (Book b : books) {
            b.displayBook();
        }
        System.out.println();
    }
}


// Testing
class LibraryBooks {
    public static void main(String[] args) {
        // Create independent books
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b3 = new Book("Clean Code", "Robert C. Martin");

        // Create libraries
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("College Library");

        // Add books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); // same book can exist in multiple libraries
        lib2.addBook(b3);

        // Display libraries and their books
        lib1.showLibraryBooks();
        lib2.showLibraryBooks();
    }
}




