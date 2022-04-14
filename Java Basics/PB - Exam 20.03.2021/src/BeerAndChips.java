import java.util.Scanner;

public class BeerAndChips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fanName = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());
        int beerCount = Integer.parseInt(scanner.nextLine());
        int chipsCount = Integer.parseInt(scanner.nextLine());

        double totalBeerPrice = beerCount * 1.2;
        double chipsPrice = 0.45*totalBeerPrice;
        double totalChipsPrice = Math.ceil(chipsPrice *chipsCount);
        double total = totalBeerPrice + totalChipsPrice;
        double difference = Math.abs (budget - total);

        if (budget >= total){
            System.out.printf("%s bought a snack and has %.2f leva left.", fanName, difference);
        }
        else
            System.out.printf("%s needs %.2f more leva!", fanName, difference);
    }
}
