import java.util.Scanner;
import java.util.function.DoublePredicate;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberriesPrice = Double.parseDouble(scanner.nextLine());
        double bananasQuantity = Double.parseDouble(scanner.nextLine());
        double orangesQuantity = Double.parseDouble(scanner.nextLine());
        double raspberriesQuantity = Double.parseDouble(scanner.nextLine());
        double strawberriesQuantity = Double.parseDouble(scanner.nextLine());

        double raspberriesPrice = 0.5 * strawberriesPrice;
        double orangesPrice = 0.6 * raspberriesPrice;
        double bananasPrice = 0.2 * raspberriesPrice;

        double sumStrawberries = strawberriesPrice * strawberriesQuantity;
        double sumBananas = bananasPrice * bananasQuantity;
        double sumRaspberries = raspberriesPrice * raspberriesQuantity;
        double sumOranges = orangesPrice * orangesQuantity;
        double total = sumOranges + sumBananas + sumRaspberries + sumStrawberries;

        System.out.printf("%.2f",total);
    }
}
