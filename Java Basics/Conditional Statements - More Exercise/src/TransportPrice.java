import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = Integer.parseInt(scanner.nextLine());
        String timeOfDay = scanner.nextLine();
        double price = distance*0.06;

        if (distance<20 && timeOfDay.equals("day")){
            price = 0.7 + distance*0.79;
        }
        else if (distance<20 && timeOfDay.equals("night")){
            price = 0.7 + distance*0.90;
        }
        else if (distance < 100){
            price = distance*0.09;
        }
        System.out.printf("%.2f",price);
    }
}
