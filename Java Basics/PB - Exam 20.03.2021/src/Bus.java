import java.util.Scanner;

public class Bus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int passengers = Integer.parseInt(scanner.nextLine());
        int busStops = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= busStops ; i++) {
            int passengersOut = Integer.parseInt(scanner.nextLine());
            int passengersIn = Integer.parseInt(scanner.nextLine());

            if (i %2 == 1){
                passengersIn +=2;
            }
            else {
                passengersOut +=2;
            }

            passengers += passengersIn - passengersOut;
        }
        System.out.printf("The final number of passengers is : %d",passengers);
    }
}
