import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidays = Integer.parseInt(scanner.nextLine());

        int workdays = 365 - holidays;
        int playtime = holidays*127 + workdays*63;
        int difference = Math.abs(30000 - playtime);
        int differenceHours = difference/60;
        int differenceMinutes = difference%60;

        if (playtime <= 30000){
            System.out.printf("Tom sleeps well%n%d hours and %d minutes less for play",differenceHours,differenceMinutes);
        }
        else
            System.out.printf("Tom will run away%n%d hours and %d minutes more for play",differenceHours,differenceMinutes);

    }
}
