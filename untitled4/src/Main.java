import bank.DpsAccount;
import bank.FixedDepositAccount;
import bank.SavingsAccount;

public class Main {
    public static void main(String[] args) {


        SavingsAccount savingsAccount = new SavingsAccount("SA001", 1000);
        DpsAccount dpsAccount = new DpsAccount("DPS001", 5000);
        FixedDepositAccount fdAccount = new FixedDepositAccount("FD001", 10000);


        savingsAccount.deposit(500);
        savingsAccount.withdraw(200);
        System.out.println("Savings Account Interest: " + savingsAccount.calculateInterest());

        dpsAccount.deposit(1000);
        System.out.println("DPS Account Interest: " + dpsAccount.calculateInterest());

        fdAccount.withdraw(2000);
        System.out.println("Fixed Deposit Account Interest: " + fdAccount.calculateInterest());
    }
}