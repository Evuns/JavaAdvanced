package DefiningClasses.Lab.BankAccount;

public class BankAccount {

    private static int bankAccount = 1;
    private static final double RATE_DEFAULT_VALUE = 0.02;

    private int id;
    private double balance;
    private static double interestRate = RATE_DEFAULT_VALUE;


    public  static void setInterestRate(double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public BankAccount(){
        this.id = bankAccount++;
    }

    public int getId(){
        return id;
    }

    public double getInterest(int years){
        return BankAccount.interestRate*years*this.balance;
    }

   public void  deposit(double amount){
        this.balance += amount;
   }

}
