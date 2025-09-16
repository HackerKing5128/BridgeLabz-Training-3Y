import java.util.*;

// Bank class
class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // Method to open account for a customer
    public void openAccount(Customer customer, double initialDeposit) {
        Account account = new Account(this, initialDeposit);
        customer.addAccount(account);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println(customer.getName() + " opened an account at " + name
                + " with balance: " + initialDeposit);
    }

    public String getName() {
        return name;
    }
}

// Account class
class Account {
    private static int idCounter = 1000;
    private int accountId;
    private double balance;
    private Bank bank;

    public Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
        this.accountId = idCounter++;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}

// Customer class
class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Add account to customer
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // View balances of all accounts
    public void viewBalance() {
        System.out.println("Customer: " + name + " - Accounts:");
        for (Account acc : accounts) {
            System.out.println("\tBank: " + acc.getBank().getName()
                    + ", Balance: " + acc.getBalance());
        }
        System.out.println();
    }
}

// testing class
public class BankCustomers {
    public static void main(String[] args) {
        Bank bank1 = new Bank("UCO Bank");
        Bank bank2 = new Bank("SBI Bank");

        Customer c1 = new Customer("Nayan");
        Customer c2 = new Customer("Yash");

        // Customers opening accounts in different banks
        bank1.openAccount(c1, 5000);
        bank1.openAccount(c2, 10000);

        bank2.openAccount(c1, 2000);
        System.out.println();

        // View balances
        c1.viewBalance();
        c2.viewBalance();
    }
}
