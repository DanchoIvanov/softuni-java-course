import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f",totalProducts(input, quantity));
    }

    public static double totalProducts(String input, int quantity){
        double price = 0;
        switch (input){
            case "coffee":
                price = 1.5;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.4;
                break;
            case "snacks":
                price = 2;
                break;
        }
        return quantity*price;
    }
}
