import java.util.Scanner;

public class ComputerRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int hoursSpent = Integer.parseInt(scanner.nextLine());
        int peopleInGroup = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double pricePerHour = 0;

        switch (month){
            case "march":
            case "april":
            case"may":
                if (timeOfDay.equals("day")){
                    pricePerHour = 10.5;
                }
                else if (timeOfDay.equals("night")){
                    pricePerHour = 8.4;
                }
                break;
            case "june":
            case "july":
            case"august":
                if (timeOfDay.equals("day")){
                    pricePerHour = 12.6;
                }
                else if (timeOfDay.equals("night")){
                    pricePerHour = 10.2;
                }
                break;
        }
        if (peopleInGroup >= 4){
            pricePerHour = 0.9 * pricePerHour;
        }
        if (hoursSpent >=5){
           pricePerHour = 0.5 * pricePerHour;
        }

        double totalPrice = pricePerHour * hoursSpent * peopleInGroup;

        System.out.printf("Price per person for one hour: %.2f%n",pricePerHour);
        System.out.printf("Total cost of the visit: %.2f",totalPrice);
    }
}
