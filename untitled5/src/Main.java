import bank.DpsAccount;
import bank.FixedDepositAccount;
import bank.SavingsAccount;

public class Main {
    public static void main(String[] args) {
        FixedDepositAccount sc = new FixedDepositAccount("A5",10000);
        sc.deposit(5000);
        sc.withdraw(2000);
        System.out.println(" interest of fixed deposit=" + sc.calculateInterest());

        SavingsAccount sc1 = new SavingsAccount("A5",20000);
        sc1.deposit(5000);
        sc1.withdraw(2000);
        System.out.println(" interest of saving deposit=" + sc1.calculateInterest());
        DpsAccount sc2 = new DpsAccount("A5",30000);
        sc2.deposit(5000);
        sc2.withdraw(2000);
        System.out.println(" interest of Dps deposit=" + sc2.calculateInterest());
    }
}
//
//1. Create a superclass named 'BankAccount' with the parameter 'accountNumber,'
// 'balance,' and 'interestRate.' and add some methods like 'deposit()' and 'withdraw()'
// that apply to all account types.
//
//        2. Create subclasses for different types of bank accounts, like 'SavingsAccount,
//        ' 'DpsAccount,' and 'FixedDepositAccount,' which inherit from the 'BankAccount'
//        superclass.
//
//3. Create different types of objects using these classes.
//
//        4. Add a method like 'calculateInterest()' which will return different types of
//        interest for different types of bank accounts.