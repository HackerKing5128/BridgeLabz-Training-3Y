// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem implements Reservable {
    private String itemId;
    private String title;
    private String author;
    private String borrower;
    private boolean isReserved;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
        this.borrower = null;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // masked borrower details for privacy
    public String getBorrowerDetails() {
        if (borrower == null) return "Not borrowed";
        return "Borrower: " + borrower.charAt(0) + "****";
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Reserved: " + (isReserved ? "Yes" : "No"));
        System.out.println(getBorrowerDetails());
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            this.borrower = borrowerName;
            this.isReserved = true;
            System.out.println(title + " reserved for " + borrowerName);
        } else {
            System.out.println(title + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Book class
class Book extends LibraryItem {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 10; // 10 days for books
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }
}

// DVD class
class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }
}

// Main testing class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[3];

        items[0] = new Book("B001", "Wings Of Fire", "Dr. A.P.J. Abdul Kalam");
        items[1] = new Magazine("M101", "National Geographic", "Editorial Team");
        items[2] = new DVD("D202", "Inception", "Christopher Nolan");

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Try reserving each item
            if (item.checkAvailability()) {
                item.reserveItem("Charlie");
            } else {
                System.out.println(item.getTitle() + " is not available.");
            }

            System.out.println("-----------------------------------");
        }
    }
}
