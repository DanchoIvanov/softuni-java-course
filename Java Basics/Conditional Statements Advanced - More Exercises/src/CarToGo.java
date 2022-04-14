import java.util.Scanner;

public class CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double price = 0;
        String type = "";
        String carClass = "";

        if (budget <= 100){
            if (season.equals("Summer")){
                price = budget*0.35;
                type = "Cabrio";
                carClass = "Economy class";
            }
            else if (season.equals("Winter")){
                price = budget*0.65;
                type = "Jeep";
                carClass = "Economy class";
            }
        }
        else if (budget <= 500){
            if (season.equals("Summer")){
                price = budget*0.45;
                type = "Cabrio";
                carClass = "Compact class";
            }
            else if (season.equals("Winter")){
                price = budget*0.8;
                type = "Jeep";
                carClass = "Compact class";
            }
        }
        else {
            price = budget*0.9;
            type = "Jeep";
            carClass = "Luxury class";
        }
        System.out.println(carClass);
        System.out.printf("%s - %.02f",type, price);
    }
}
