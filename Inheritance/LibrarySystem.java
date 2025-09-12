// Superclass
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book Title: " + title + ", Published: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        System.out.println("Book Title: " + title + ", Published: " + publicationYear);
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Author a1 = new Author("The Great Adventure", 2021, "John Smith",
                "John is a novelist known for his adventure stories.");

        a1.displayInfo();
    }
}
