import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double money = 0;
        String input = scanner.nextLine();

        while (!input.equals("Start")){
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2){
                money += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n",coin);
            }
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        double price = 0;

        while(!input.equals("End")){
            switch (input){
                case "Nuts":
                    price = 2;
                    if(price <= money){
                        System.out.printf("Purchased %s%n",input);
                        money -= price;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    price = 0.7;
                    if(price <= money){
                        System.out.printf("Purchased %s%n",input);
                        money -= price;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    price = 1.5;
                    if(price <= money){
                        System.out.printf("Purchased %s%n",input);
                        money -= price;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    price = 0.8;
                    if(price <= money){
                        System.out.printf("Purchased %s%n",input);
                        money -= price;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    price = 1;
                    if(price <= money){
                        System.out.printf("Purchased %s%n",input);
                        money -= price;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");

            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f",money);
    }
}
