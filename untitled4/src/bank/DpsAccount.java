package bank;

import bank.BankAccount;

public class DpsAccount extends BankAccount {
    public DpsAccount(String accountNumber, double balance) {
        super(accountNumber, balance, 0.05);

    }
}
