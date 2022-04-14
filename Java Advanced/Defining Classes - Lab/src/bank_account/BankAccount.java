package bank_account;

public class BankAccount {

    private int id;
    private static int bankAccountCount = 1;
    private double balance;
    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    public BankAccount(){
        this.id = bankAccountCount ++;
    }

    public int getId() {
        return id;
    }


    public double getBalance() {
        return balance;
    }

    public static void setInterestRate (double interestRate){
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public double getInterestRate(int years){
        return this.balance * years * interestRate;
    }
}
