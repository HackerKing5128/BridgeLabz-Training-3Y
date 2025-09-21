import java.util.*;

interface Transferrable {
    boolean transferTo(User receiver, double amount);
}

// Transaction class
class Transaction {
    private String details;
    private double amount;

    public Transaction(String details, double amount) {
        this.details = details;
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public double getAmount() {
        return amount;
    }

    public void displayTransaction() {
        System.out.println(details + ": Rs." + amount);
    }
}

// Wallet base class
abstract class Wallet implements Transferrable {
    private double balance;
    protected List<Transaction> history;

    public Wallet(double initialBalance) {
        this.balance = initialBalance;
        this.history = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    protected void addBalance(double amount) {
        balance += amount;
    }

    protected boolean deductBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void addTransaction(Transaction t) {
        history.add(t);
    }

    public void showHistory(String userName) {
        System.out.println(userName + "'s Transaction History:");
        if (history.size() > 0) {
            for (Transaction t : history) {
                t.displayTransaction();
            }
        } else {
            System.out.println("No Transaction history found!");
        }
    }
}

// PersonalWallet class
class PersonalWallet extends Wallet {
    public PersonalWallet(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public boolean transferTo(User receiver, double amount) {
        // assume simple 2% tax
        double tax = amount * 0.02;
        if (deductBalance(amount + tax)) {
            receiver.getWallet().addBalance(amount);
            addTransaction(new Transaction("Transferred Rs." + amount + " to " + receiver.getName(), amount));
            return true;
        }
        System.out.println("Insufficient balance for transfer.");
        return false;
    }
}

// BusinessWallet class
class BusinessWallet extends Wallet {
    public BusinessWallet(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public boolean transferTo(User receiver, double amount) {
        // Business wallet - higher limit, 1% tax
        double tax = amount * 0.01;
        if (deductBalance(amount + tax)) {
            receiver.getWallet().addBalance(amount);
            addTransaction(new Transaction("Business transfer Rs." + amount + " to " + receiver.getName(), amount));
            return true;
        }
        System.out.println("Insufficient balance for transfer.");
        return false;
    }
}

// User class
class User {
    private String name;
    private Wallet wallet;

    public User(String name, boolean isBusiness, double initialBalance, boolean referralBonus) {
        this.name = name;
        double bonus = referralBonus ? 50 : 0; // Optional bonus
        if (isBusiness)
            wallet = new BusinessWallet(initialBalance + bonus);
        else
            wallet = new PersonalWallet(initialBalance + bonus);
    }

    public String getName() {
        return name;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void showBalance() {
        System.out.println(name + "'s Wallet Balance: Rs." + wallet.getBalance());
    }
}

// Main test class
public class EWalletApplication {
    public static void main(String[] args) {
        User u1 = new User("Henry", false, 500, true); // Personal wallet with referral
        User u2 = new User("Yash", true, 1000, false);  // Business wallet

        u1.showBalance();
        u2.showBalance();
        System.out.println();
        // Transfer money
        u1.getWallet().transferTo(u2, 100);
        u1.showBalance();
        u2.showBalance();
        System.out.println();

        // Add transactions
        u1.getWallet().showHistory(u1.getName());
        u2.getWallet().showHistory(u2.getName());
    }
}
