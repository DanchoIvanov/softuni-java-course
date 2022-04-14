package hotel_reservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        String seasonAsSting = input[2];
        String discountTypeAsString = input[3];

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, seasonAsSting, discountTypeAsString);
        System.out.printf("%.2f",priceCalculator.calculatePrice());
    }
}
