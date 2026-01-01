package bank;

import bank.BankAccount;

public class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {

        super(accountNumber, balance, 0.02);
    }
}
