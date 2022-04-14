import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int campaignLength = Integer.parseInt(scanner.nextLine());
        int confectioners = Integer.parseInt(scanner.nextLine());
        int cakesMade = Integer.parseInt(scanner.nextLine());
        int wafflesMade = Integer.parseInt(scanner.nextLine());
        int pancakesMade = Integer.parseInt(scanner.nextLine());

        int sumCakes = cakesMade * 45;
        double sumWaffles = wafflesMade * 5.8;
        double sumPancakes = pancakesMade * 3.2;
        double dailyCashTurnover = (sumCakes + sumPancakes + sumWaffles) * confectioners;
        double campaignCashTurnover = dailyCashTurnover * campaignLength;
        double campaignProfit = campaignCashTurnover - campaignCashTurnover / 8;

        System.out.printf("%.2f",campaignProfit);

    }
}
