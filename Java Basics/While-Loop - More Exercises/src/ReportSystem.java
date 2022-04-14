import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int requiredMoney = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int transactionCount = 0;
        int csCount = 0;
        int totalCash =0;
        int ccCount = 0;
        int totalCC = 0;
        boolean isReached = false;

        while (!input.equals("End")){
            int currentAmount = Integer.parseInt(input);
            transactionCount++;
            if (transactionCount %2 == 1 && currentAmount <= 100){
                csCount ++;
                totalCash += currentAmount;
                System.out.println("Product sold!");
            }
            else if (transactionCount %2 == 1 && currentAmount > 100){
                System.out.println("Error in transaction!");
            }
            else if (transactionCount %2 == 0 && currentAmount >= 10){
                ccCount ++;
                totalCC += currentAmount;
                System.out.println("Product sold!");
            }
            else if (transactionCount %2 == 0 && currentAmount <10){
                System.out.println("Error in transaction!");
            }
            if ((totalCash + totalCC) >=requiredMoney){
                isReached = true;
                break;
            }
            input = scanner.nextLine();
        }
        double averageCash = (totalCash * 1.0 / csCount);
        double averageCC = (totalCC * 1.0 / ccCount);

        if (isReached){
            System.out.printf("Average CS: %.2f%n Average CC: %.2f%n",averageCash,averageCC);
        }
        else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}
