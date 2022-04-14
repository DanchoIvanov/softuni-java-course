import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int students = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());

        double pricePerNight = 0;
        double discount = 1;
        String sport = "";

        if (groupType.equals("girls")){
            if (season.equals("Winter")){
                pricePerNight = 9.6;
                sport = "Gymnastics";
            }
            else if (season.equals("Spring")){
                pricePerNight = 7.2;
                sport = "Athletics";
            }
            else if (season.equals("Summer")){
                pricePerNight = 15;
                sport = "Volleyball";
            }
        }
        else if (groupType.equals("boys")){
            if (season.equals("Winter")){
                pricePerNight = 9.6;
                sport = "Judo";
            }
            else if (season.equals("Spring")){
                pricePerNight = 7.2;
                sport = "Tennis";
            }
            else if (season.equals("Summer")){
                pricePerNight = 15;
                sport = "Football";
            }
        }
        else if (groupType.equals("mixed")){
            if (season.equals("Winter")){
                pricePerNight = 10;
                sport = "Ski";
            }
            else if (season.equals("Spring")){
                pricePerNight = 9.5;
                sport = "Cycling";
            }
            else if (season.equals("Summer")){
                pricePerNight = 20;
                sport = "Swimming";
            }
        }
        if (students >= 50){
            discount = 0.5;
        }
        else if (students >= 20){
            discount = 0.85;
        }
        else if (students >= 10){
            discount = 0.95;
        }
        double total = nights * students * pricePerNight *discount;
        System.out.printf("%s %.2f lv.",sport, total);
    }
}
