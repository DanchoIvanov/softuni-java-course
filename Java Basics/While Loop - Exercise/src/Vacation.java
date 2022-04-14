import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyNeeded = Double.parseDouble(scanner.nextLine());
        double ownedMoney = Double.parseDouble(scanner.nextLine());
        int spendCount = 0;
        int daysCount = 0;



        while ((moneyNeeded > ownedMoney) && spendCount < 5){
            String action = scanner.nextLine();
            double currentMoney = Double.parseDouble(scanner.nextLine());
            daysCount++;
            if (action.equals("save")){
                ownedMoney += currentMoney;
                spendCount = 0;
            }
            else if (action.equals("spend")){
                ownedMoney -=currentMoney;
                spendCount++;
                if (ownedMoney < 0){
                    ownedMoney = 0;
                }
                if (spendCount == 5){
                    System.out.println("You can't save the money.");
                    System.out.println(daysCount);
                    break;
                }
            }
        }
        if (ownedMoney >= moneyNeeded){
            System.out.printf("You saved the money for %d days.",daysCount);
        }
    }
}
