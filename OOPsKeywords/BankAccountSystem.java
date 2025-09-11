class BankAccount {
    // Static variables
    static String bankName = "Ahjin Bank";
    static int totalAccounts = 0;

    // Instance variables
    String accountHolderName;
    final int accountNumber;

    // Constructor
    public BankAccount(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber; // final assigned once here
        totalAccounts++;
    }

    // Static method to display total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    // Method to display account details using instanceof
    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }
    }
}


public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Johnny English", 10101);
        BankAccount acc2 = new BankAccount("Alice Smith", 10201);

        acc1.displayDetails();
        System.out.println("----------------");
        acc2.displayDetails();

        System.out.println("----------------");
        BankAccount.getTotalAccounts();
    }
}
