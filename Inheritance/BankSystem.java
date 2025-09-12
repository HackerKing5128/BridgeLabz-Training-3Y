// Base class
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Balance: Rs." + balance);
    }

    void displayAccountType() {
        System.out.println("General Bank Account");
    }
}

// Subclass: Savings Account
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Savings Account, Interest Rate: " + interestRate + "%");
    }
}

// Subclass: Checking Account
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Checking Account, Withdrawal Limit: Rs." + withdrawalLimit);
    }
}

// Subclass: Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    int depositTerm; // in months

    FixedDepositAccount(String accountNumber, double balance, int depositTerm) {
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account, Deposit Term: " + depositTerm + " months");
    }
}

// Testing class
public class BankSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SAV123", 5000, 4.5);
        BankAccount acc2 = new CheckingAccount("CHK456", 3000, 1000);
        BankAccount acc3 = new FixedDepositAccount("FD789", 10000, 12);

        // Polymorphism in action
        acc1.displayDetails();
        acc1.displayAccountType();
        System.out.println();

        acc2.displayDetails();
        acc2.displayAccountType();
        System.out.println();

        acc3.displayDetails();
        acc3.displayAccountType();
    }
}
