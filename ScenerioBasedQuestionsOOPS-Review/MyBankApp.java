interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

// Base Account class
abstract class Account implements ITransaction {
    private String accountNumber;
    private double balance;

    // Constructor without opening balance (default 0)
    public Account(String accountNumber) {
        this(accountNumber, 0.0);
    }

    // Constructor with opening balance
    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }


    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract double calculateInterest();
}

// SavingsAccount
class SavingsAccount extends Account {
    private double interestRate = 4.0; // 4% interest

    public SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public double calculateInterest() {
        double interest = checkBalance() * interestRate / 100;
        return interest;
    }
}

// CurrentAccount
class CurrentAccount extends Account {
    private double interestRate = 1.5; // 1.5% interest

    public CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    public CurrentAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public double calculateInterest() {
        double interest = checkBalance() * interestRate / 100;
        return interest;
    }
}

// testing class
public class MyBankApp {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA123", 1000);
        CurrentAccount ca = new CurrentAccount("CA456", 2000);

        sa.deposit(500);
        sa.withdraw(300);
        System.out.println("Savings Balance: " + sa.checkBalance());
        System.out.println("Savings Interest: " + sa.calculateInterest());

        System.out.println();

        ca.deposit(1000);
        ca.withdraw(2500); // fail due to insufficient funds
        System.out.println("Current Balance: " + ca.checkBalance());
        System.out.println("Current Interest: " + ca.calculateInterest());
    }
}
