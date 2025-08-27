class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs. " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: Rs. " + amount);
            } else {
                System.out.println("Insufficient balance. Withdrawal denied.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Check balance method
    public double checkBalance() {
        System.out.println("Current balance: Rs. " + balance);
        return balance;
    }

}


class BankAccountManager {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 5000);
        account.checkBalance();
        account.deposit(500);
        account.checkBalance();
        account.withdraw(500000);
        account.withdraw(50);
        account.checkBalance();

    }
}

