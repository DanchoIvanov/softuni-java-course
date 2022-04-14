import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        int fuelQuantity = Integer.parseInt(scanner.nextLine());

        String[] fuel = {"Gas", "Gasoline", "Diesel"};

        if (!Arrays.asList(fuel).contains(fuelType))
            System.out.println("Invalid fuel!");

        else if (fuelQuantity<25){
            fuelType = fuelType.toLowerCase(Locale.ROOT);
            System.out.printf("Fill your tank with %s!",fuelType);
        }
        else if (fuelQuantity >= 25){
            fuelType = fuelType.toLowerCase(Locale.ROOT);
            System.out.printf("You have enough %s.",fuelType);
        }
    }
}
