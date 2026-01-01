package bank;

public class DpsAccount extends BankAccount{
    public DpsAccount(String accountNumber,double balance){
        super(accountNumber,balance,0.02);
    }
}
