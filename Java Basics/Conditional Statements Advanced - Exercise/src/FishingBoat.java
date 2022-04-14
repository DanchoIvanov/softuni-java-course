import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisherman = Integer.parseInt(scanner.nextLine());

        double discount = 1;
        int price = 0;

        //Check for boat price
        if (season.equals("Spring")){
            price = 3000;
        }
        else if (season.equals("Summer") || season.equals("Autumn")){
            price = 4200;
        }
        else if (season.equals("Winter")){
            price = 2600;
        }

        //Check for discount based on fisherman count
        if (fisherman <= 6){
            discount = 0.9;
        }
        else if (fisherman <= 11){
            discount = 0.85;
        }
        else {
            discount = 0.75;
        }

        //Check for additional discount
        if (!season.equals("Autumn") && fisherman % 2 == 0){
            discount = discount - 0.05;
        }

        double totalPrice = price*discount;
        double difference = Math.abs(budget-totalPrice);

        //Check if budget is big enough
        if (budget >= totalPrice){
            System.out.printf("Yes! You have %.2f leva left.", difference);
        }
        else
            System.out.printf("Not enough money! You need %.2f leva.", difference);
    }
}
