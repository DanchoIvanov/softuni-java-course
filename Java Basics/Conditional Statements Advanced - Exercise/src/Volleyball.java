import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine();
        int holidays = Integer.parseInt(scanner.nextLine());
        int weekendsOutsideSofia = Integer.parseInt(scanner.nextLine());

        int weekendsInSofia = 48 - weekendsOutsideSofia;
        double gamesInSofia = weekendsInSofia*3/4.0;
        double gamesDuringHolidays = holidays*2/3.0;
        double gamesPerYear = weekendsOutsideSofia+gamesInSofia+gamesDuringHolidays;

        if (year.equals("leap")){
            System.out.printf("%.0f",Math.floor(gamesPerYear*1.15));
        }
        else if (year.equals("normal")){
            System.out.printf("%.0f",Math.floor(gamesPerYear));
        }
    }
}
