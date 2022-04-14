package bank_account;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List <BankAccount> bankAccounts = new LinkedList<>();
        while(!input.equals("End")){
            String command = input.split("\\s+")[0];
            switch (command){
                case "Create":
                    BankAccount newAccount = new BankAccount();
                    bankAccounts.add(newAccount);
                    System.out.printf("Account ID%d created%n",bankAccounts.get(bankAccounts.size()-1).getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(input.split("\\s+")[1]);
                    double deposit = Double.parseDouble(input.split("\\s+")[2]);
                    if (id-1 >= 0 && id-1 < bankAccounts.size()){
                        bankAccounts.get(id-1).deposit(deposit);
                        System.out.printf("Deposited %.0f to ID%d%n",deposit, id);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(input.split("\\s+")[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(input.split("\\s+")[1]);
                    int years = Integer.parseInt(input.split("\\s+")[2]);
                    if (id-1 >= 0 && id-1 < bankAccounts.size()){
                        System.out.printf("%.2f%n", bankAccounts.get(id - 1).getInterestRate(years));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
