import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kilometers = Double.parseDouble(scanner.nextLine());
        double price = 0;

        if (kilometers <= 5000){
            if (season.equals("Spring") || season.equals("Autumn")){
                price = 0.75;
            }
            else if (season.equals("Summer")){
                price = 0.9;
            }
            else if (season.equals("Winter")){
                price = 1.05;
            }
        }
        else if (kilometers <= 10000){
            if (season.equals("Spring") || season.equals("Autumn")){
                price = 0.95;
            }
            else if (season.equals("Summer")){
                price = 1.1;
            }
            else if (season.equals("Winter")){
                price = 1.25;
            }
        }
        else if (kilometers <= 20000){
            price = 1.45;
        }

        double total = 4 * kilometers * price * 0.9;

        System.out.printf("%.2f",total);
    }
}
