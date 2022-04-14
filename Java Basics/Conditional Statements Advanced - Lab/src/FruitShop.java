import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double productPrice = 0;

        switch (day){
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                switch (product){
                    case "banana":
                        productPrice = 2.5;
                        break;
                    case "apple":
                        productPrice = 1.2;
                        break;
                    case "orange":
                        productPrice = 0.85;
                        break;
                    case "grapefruit":
                        productPrice = 1.45;
                        break;
                    case "kiwi":
                        productPrice = 2.7;
                        break;
                    case "pineapple":
                        productPrice = 5.5;
                        break;
                    case "grapes":
                        productPrice = 3.85;
                        break;


                }
            break;
            case "Saturday":
            case "Sunday":
                switch (product){
                    case "banana":
                        productPrice = 2.7;
                        break;
                    case "apple":
                        productPrice = 1.25;
                        break;
                    case "orange":
                        productPrice = 0.9;
                        break;
                    case "grapefruit":
                        productPrice = 1.6;
                        break;
                    case "kiwi":
                        productPrice = 3;
                        break;
                    case "pineapple":
                        productPrice = 5.6;
                        break;
                    case "grapes":
                        productPrice = 4.20;
                        break;
                }
            break;
        }
        double totalPrice = productPrice*quantity;

        if (productPrice == 0) {
            System.out.println("error");
        }
        else
            System.out.printf("%.2f",totalPrice);
    }
}
