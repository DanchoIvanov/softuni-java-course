import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceFlour = Double.parseDouble(scanner.nextLine());
        double priceEgg = Double.parseDouble(scanner.nextLine());
        double priceApron = Double.parseDouble(scanner.nextLine());

        double totalPriceApron = Math.ceil(students*1.2) *priceApron;
        int freePackages = students/5;
        double totalPriceFlour = (students - freePackages) * priceFlour;
        double totalPriceEggs = students * 10 * priceEgg;

        double totalPrice = totalPriceApron + totalPriceFlour + totalPriceEggs;
        boolean isEnough = budget>=totalPrice;

        if (isEnough){
            System.out.printf("Items purchased for %.2f$.",totalPrice);
        } else {
            double difference = totalPrice - budget;
            System.out.printf("%.2f$ more needed.",difference);
        }
    }
}
