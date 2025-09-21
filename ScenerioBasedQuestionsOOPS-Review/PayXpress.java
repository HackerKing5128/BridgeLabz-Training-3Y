import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Interface
interface IPayable {
    void pay();

    void sendReminder();
}

// Base Bill class
abstract class Bill implements IPayable {
    private String type;
    protected double amount;
    private LocalDate dueDate;
    private boolean isPaid;

    public Bill(String type, double amount, LocalDate dueDate) {
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
        this.isPaid = false;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    protected void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    public double calculateLateFee() {
        long daysLate = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        if (daysLate > 0) {
            return amount + daysLate * 5; // Rs.5/day late fee
        }
        return amount;
    }

    public void printBill() {
        System.out.println(type + " Bill | Amount: Rs." + amount +
                " | Due: " + dueDate + " | Paid: " + isPaid);
    }
}

// ElectricityBill
class ElectricityBill extends Bill {
    public ElectricityBill(double amount, LocalDate dueDate) {
        super("Electricity", amount, dueDate);
    }

    @Override
    public void pay() {
        setPaid(true);
        System.out.println("Electricity bill paid. Thank you!");
    }

    @Override
    public void sendReminder() {
        if (!getIsPaid()) {
            System.out.println("Reminder: Pay your electricity bill of Rs." + amount);
        }
    }
}

// WaterBill
class WaterBill extends Bill {
    public WaterBill(double amount, LocalDate dueDate) {
        super("Water", amount, dueDate);
    }

    @Override
    public void pay() {
        setPaid(true);
        System.out.println("Water bill paid successfully.");
    }

    @Override
    public void sendReminder() {
        if (!getIsPaid()) {
            System.out.println("Reminder: Water bill of Rs." + amount + " is pending!");
        }
    }
}

// InternetBill
class InternetBill extends Bill {
    public InternetBill(double amount, LocalDate dueDate) {
        super("Internet", amount, dueDate);
    }

    @Override
    public void pay() {
        setPaid(true);
        System.out.println("Internet bill paid successfully.");
    }

    @Override
    public void sendReminder() {
        if (!getIsPaid()) {
            System.out.println("Reminder: Internet bill of Rs." + amount + " is due!");
        }
    }
}

// Demo
public class PayXpress {
    public static void main(String[] args) {
        Bill elec = new ElectricityBill(1200, LocalDate.now().plusDays(3));
        Bill water = new WaterBill(500, LocalDate.now().minusDays(2));
        Bill internet = new InternetBill(800, LocalDate.now().plusDays(5));

        elec.printBill();
        water.printBill();
        internet.printBill();
        System.out.println();

        // Send reminders
        elec.sendReminder();
        water.sendReminder();
        internet.sendReminder();
        System.out.println();

        // Pay a bill
        water.pay();
        water.printBill();

        System.out.println("Water bill with late fee: Rs." + water.calculateLateFee());
    }
}
