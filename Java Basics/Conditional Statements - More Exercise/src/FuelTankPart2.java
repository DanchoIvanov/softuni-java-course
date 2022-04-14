import java.util.Scanner;

public class FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelQuantity = Double.parseDouble(scanner.nextLine());
        String clubCard = scanner.nextLine();

        double price = 0;
        double discount = 1;

        if (fuelType.equals("Gas") && clubCard.equals("No")){
            price = 0.93;
        }
        else if (fuelType.equals("Gasoline") && clubCard.equals("No")){
            price = 2.22;
        }
        else if (fuelType.equals("Diesel") && clubCard.equals("No")){
            price = 2.33;
        }
        else if (fuelType.equals("Gas") && clubCard.equals("Yes")){
            price = 0.85;
        }
        else if (fuelType.equals("Gasoline") && clubCard.equals("Yes")){
            price = 2.04;
        }
        else if (fuelType.equals("Diesel") && clubCard.equals("Yes")){
            price = 2.21;
        }

        if (fuelQuantity > 25){
            discount = 0.9;
        }
        else if (fuelQuantity >=20){
            discount = 0.92;
        }
        double totalPrice = fuelQuantity * price * discount;

        System.out.printf("%.2f lv.",totalPrice);
    }
}
