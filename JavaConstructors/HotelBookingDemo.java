class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    // Default constructor
    HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }
}

public class HotelBookingDemo {
    public static void main(String[] args) {
        HotelBooking hb1 = new HotelBooking();
        HotelBooking hb2 = new HotelBooking("Bob", "Deluxe", 3);
        HotelBooking hb3 = new HotelBooking(hb2);

        hb1.display();
        hb2.display();
        hb3.display();
    }
}
