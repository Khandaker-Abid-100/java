package bank;

public class FixedDepositAccount extends BankAccount{
   public FixedDepositAccount(String accountNumber,double balance){
        super(accountNumber,balance,0.05);
    }
}
