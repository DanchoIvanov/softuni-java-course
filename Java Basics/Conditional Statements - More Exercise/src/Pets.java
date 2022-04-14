import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int foodLeft = Integer.parseInt(scanner.nextLine());
        double dogFood = Double.parseDouble(scanner.nextLine());
        double catFood = Double.parseDouble(scanner.nextLine());
        double turtleFood = (Double.parseDouble(scanner.nextLine()))/1000;

        double dogFoodNeeded = dogFood*days;
        double catFoodNeeded = catFood*days;
        double turtleFoodNeeded = turtleFood*days;
        double totalFoodNeeded = dogFoodNeeded+catFoodNeeded+turtleFoodNeeded;
        double difference = Math.abs(foodLeft-totalFoodNeeded);
        double differenceRounded = Math.ceil(difference);

        if (foodLeft>=totalFoodNeeded){
            differenceRounded = Math.floor(difference);
            System.out.printf("%.0f kilos of food left.",differenceRounded);
        }
        else
            System.out.printf("%.0f more kilos of food are needed.",differenceRounded);
    }
}
