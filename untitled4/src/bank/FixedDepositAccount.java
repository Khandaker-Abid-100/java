package bank;

import bank.BankAccount;

public class FixedDepositAccount extends BankAccount {
    public FixedDepositAccount(String accountNumber, double balance) {
        super(accountNumber, balance, 0.08);
    }
}
