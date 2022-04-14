import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double price = 0;
        String location = "";
        String hotelType = "";

        if (budget <= 1000){
            if (season.equals("Summer")){
                price = budget*0.65;
                location = "Alaska";
                hotelType = "Camp";
            }
            else if (season.equals("Winter")){
                price = budget*0.45;
                location = "Morocco";
                hotelType = "Camp";
            }
        }
        else if (budget <= 3000){
            if (season.equals("Summer")){
                price = budget*0.8;
                location = "Alaska";
                hotelType = "Hut";
            }
            else if (season.equals("Winter")){
                price = budget*0.6;
                location = "Morocco";
                hotelType = "Hut";
            }
        }
        else if (budget > 3000) {

            price = budget * 0.9;
            hotelType = "Hotel";

            if (season.equals("Summer")) {
                location = "Alaska";
            } else if (season.equals("Winter")) {
                location = "Morocco";
            }
        }

        System.out.printf("%s - %s - %.02f", location, hotelType, price);
    }
}