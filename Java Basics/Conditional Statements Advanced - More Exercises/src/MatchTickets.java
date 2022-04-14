import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String ticketType = scanner.nextLine();
        int fans = Integer.parseInt(scanner.nextLine());

        if (fans >= 1 && fans <= 4) {
            budget = 0.25 * budget;
        } else if (fans <= 9) {
            budget = 0.4 * budget;
        } else if (fans <= 24) {
            budget = 0.5 * budget;
        } else if (fans <= 49) {
            budget = 0.6 * budget;
        } else {
            budget = 0.75 * budget;
        }

        double ticketPrice = 0;

        if (ticketType.equals("VIP")){
            ticketPrice =499.99;
        }
        else if (ticketType.equals("Normal")){
            ticketPrice = 249.99;
        }

        double totalTicketPrice = ticketPrice * fans;
        double difference = Math.abs(totalTicketPrice - budget);

        if (totalTicketPrice <= budget){
            System.out.printf("Yes! You have %.2f leva left.",difference);
        }
        else
            System.out.printf("Not enough money! You need %.2f leva.",difference);
    }
}
