import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String holidayType = "";
        double price = 0;

        if (budget <=100){
            destination = "Bulgaria";
            if (season.equals("summer")){
                holidayType = "Camp";
                price = 0.3*budget;
            }
            else if (season.equals("winter")){
                holidayType = "Hotel";
                price = 0.7*budget;
            }
        }
        else if (budget <=1000){
            destination = "Balkans";
            if (season.equals("summer")){
                holidayType = "Camp";
                price = 0.4*budget;
            }
            else if (season.equals("winter")){
                holidayType = "Hotel";
                price = 0.8*budget;
            }
        }
        else {
            destination = "Europe";
            holidayType = "Hotel";
            price = 0.9*budget;
            }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", holidayType, price);
        }
    }

