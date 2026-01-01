package bank;

public class BankAccount {
  private String accountNumber;

  private double  balance;
  private double interestRate;
  BankAccount(){

  }
  BankAccount(String accountNumber,double balance,double interestRate){
      this.accountNumber = accountNumber;
      this.balance = balance;
      this.interestRate = interestRate;
  }
   public void deposit(double amount){

       balance = balance + amount;
       System.out.println("deposited "+amount + "account number = "+ accountNumber+" new balance "+balance);
    }
    public void withdraw(double amount){
       if (balance>=amount)
       {
           balance = balance - amount;
           System.out.println("withdrawed "+amount + "account number = "+ accountNumber+" new balance "+balance);

       }
       else {
           System.out.println("not suffient balance");

       }

    }
    public double calculateInterest(){
      return balance * interestRate;
    }
}
