import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowers = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double discount = 1;
        double price = 0;

        if (flowers.equals("Roses")){
            price = 5;
            if (quantity > 80){
                discount =0.9;
            }
        }
        else if (flowers.equals("Dahlias")){
            price = 3.8;
            if (quantity > 90){
                discount =0.85;
            }
        }
        else if (flowers.equals("Tulips")){
            price = 2.8;
            if (quantity > 80){
                discount =0.85;
            }
        }
        else if (flowers.equals("Narcissus")){
            price = 3;
            if (quantity < 120){
                discount =1.15;
            }
        }
        else if (flowers.equals("Gladiolus")){
            price = 2.5;
            if (quantity < 80){
                discount =1.2;
            }
        }

        double totalPrice = price*quantity*discount;
        double difference = Math.abs(totalPrice - budget);

        if (budget >= totalPrice){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", quantity, flowers, difference);
        }
        else
            System.out.printf("Not enough money, you need %.2f leva more.", difference);
    }
}
