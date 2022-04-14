import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double statistClothing = Double.parseDouble(scanner.nextLine());

        double decor = budget*0.1;

        if (statists > 150){
            statistClothing = statistClothing*0.9;
        }

        double cost = statists*statistClothing+decor;
        double difference = Math.abs(budget-cost);

        if (budget<cost){
            System.out.printf("Not enough money!%nWingard needs %.2f leva more.",difference);
        }
        else System.out.printf("Action!%nWingard starts filming with %.2f leva left.",difference);
    }
}
