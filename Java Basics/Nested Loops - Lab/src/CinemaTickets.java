import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int studentTicketsCount = 0;
        int standardTicketsCount = 0;
        int kidTicketsCount = 0;
        int currentMovieTicketsCount =0;
        int totalTicketsCount = 0;

        while (!input.equals("Finish")){
            String movieName = input;
            int emptySeats = Integer.parseInt(scanner.nextLine());
            currentMovieTicketsCount =0;

            for (int i = 1; i <= emptySeats ; i++) {
                String input1 = scanner.nextLine();
                if (input1.equals("End")){
                    break;
                }
                if (input1.equals("student")){
                    studentTicketsCount++;
                    currentMovieTicketsCount++;
                    totalTicketsCount++;
                }
                else if (input1.equals("standard")){
                    standardTicketsCount++;
                    currentMovieTicketsCount++;
                    totalTicketsCount++;
                }
                else if (input1.equals("kid")){
                    kidTicketsCount++;
                    currentMovieTicketsCount++;
                    totalTicketsCount++;
                }

            }
            double percentageMovieFull = (currentMovieTicketsCount * 1.0 / emptySeats) * 100;
            System.out.printf("%s - %.2f%% full.%n",movieName,percentageMovieFull);
            input = scanner.nextLine();
        }
        double percentageStudentTickets = (studentTicketsCount * 1.0 / totalTicketsCount) * 100;
        double percentageStandardTickets = (standardTicketsCount * 1.0 / totalTicketsCount) * 100;
        double percentageKidTickets = (kidTicketsCount * 1.0 / totalTicketsCount) * 100;

        System.out.printf("Total tickets: %d%n",totalTicketsCount);
        System.out.printf("%.2f%% student tickets.%n",percentageStudentTickets);
        System.out.printf("%.2f%% standard tickets.%n",percentageStandardTickets);
        System.out.printf("%.2f%% kids tickets.%n",percentageKidTickets);
    }
}
