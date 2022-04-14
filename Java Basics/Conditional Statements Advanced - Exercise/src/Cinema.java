import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double ticketPrice = 0;

        switch (projection) {
            case "Premiere":
                ticketPrice = 12;
                break;
            case "Normal":
                ticketPrice = 7.5;
                break;
            case "Discount":
                ticketPrice = 5;
                break;
        }
        double totalPrice = rows * columns * ticketPrice;
        System.out.printf("%.2f leva", totalPrice);
    }
}
