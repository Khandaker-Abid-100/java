package bank;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountNumber,double balance){
        super(accountNumber,balance,0.07);
    }
}
