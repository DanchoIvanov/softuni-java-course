import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nights = Integer.parseInt(scanner.nextLine())-1;
        String roomType = scanner.nextLine();
        String feedback = scanner.nextLine();

        double discount = 1;
        double roomPrice = 0;

        if (roomType.equals("apartment")){
            roomPrice = 25;
            if (nights < 10){
                discount = 0.7;
            }
            else if (nights <= 15) {
                discount = 0.65;
            }
            else {
                discount = 0.5;
            }
        }
        else if (roomType.equals("president apartment")) {
            roomPrice = 35;
            if (nights < 10){
                discount = 0.9;
            }
            else if (nights <= 15) {
                discount = 0.85;
            }
            else {
                discount = 0.8;
            }
        }
        else if (roomType.equals("room for one person")) {
            roomPrice = 18;
        }
        double price = nights*roomPrice*discount;

        if (feedback.equals("positive")) {
            System.out.printf("%.2f",price*1.25);
        }
        else if (feedback.equals("negative")){
            System.out.printf("%.2f",price*0.9);
        }
    }
}
