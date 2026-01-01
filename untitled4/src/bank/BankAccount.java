package bank;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private double interestRate;

    public BankAccount(String accountNumber, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into account " + accountNumber + ". New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from account " + accountNumber + ". New balance: " + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double calculateInterest() {
        return balance * interestRate;
    }
}
