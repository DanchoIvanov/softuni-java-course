import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double startBudget = budget;
        String input = scanner.nextLine();
        double price = 0;

        while (!input.equals("Game Time")){
            switch (input) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not found");
                    input = scanner.nextLine();
                    continue;
            }
            if (budget >= price){
                budget -= price;
                System.out.printf("Bought %s%n", input);
            } else {
                System.out.println("Too Expensive");
            }
            if (budget == 0){
                System.out.println("Out of money!");
                return;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", (startBudget - budget),budget);
    }
}
