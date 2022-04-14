import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String city = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double productPrice = 0;

        if (city.equals("Sofia")) {
            if (product.equals("coffee")) {
                productPrice = 0.5;
            }
            if (product.equals("water")) {
                productPrice = 0.8;
            }
            if (product.equals("beer")) {
                productPrice = 1.2;
            }
            if (product.equals("sweets")) {
                productPrice = 1.45;
            }
            if (product.equals("peanuts")) {
                productPrice = 1.6;
            }
        } else if (city.equals("Varna")) {
            if (product.equals("coffee")) {
                productPrice = 0.45;
            }
            if (product.equals("water")) {
                productPrice = 0.7;
            }
            if (product.equals("beer")) {
                productPrice = 1.10;
            }
            if (product.equals("sweets")) {
                productPrice = 1.35;
            }
            if (product.equals("peanuts")) {
                productPrice = 1.55;
            }
        } else if (city.equals("Plovdiv")) {
            if (product.equals("coffee")) {
                productPrice = 0.4;
            }
            if (product.equals("water")) {
                productPrice = 0.7;
            }
            if (product.equals("beer")) {
                productPrice = 1.15;
            }
            if (product.equals("sweets")) {
                productPrice = 1.3;
            }
            if (product.equals("peanuts")) {
                productPrice = 1.5;
            }
        }
        double totalPrice = productPrice*quantity;

        System.out.println(totalPrice);
    }
}