import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vacationPrice = Double.parseDouble(scanner.nextLine());
        int puzzles = Integer.parseInt(scanner.nextLine());
        int dolls = Integer.parseInt(scanner.nextLine());
        int teddyBears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double turnover = puzzles * 2.6 + dolls * 3 + teddyBears * 4.1 + minions * 8.2 + trucks * 2;
        int totalToys = puzzles + dolls + teddyBears + minions + trucks;

        if (totalToys >= 50) {
            turnover = turnover * 0.75;
        }

        double profit = turnover * 0.9;
        double difference = Math.abs(profit - vacationPrice);

        if (vacationPrice <= profit) {

            System.out.printf("Yes! %.2f lv left.", difference);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", difference);

        }
    }
}
