import java.util.Scanner;

public class VacationBooksList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pages = Integer.parseInt(scanner.nextLine());
        int pagesReadPerHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int readTime = pages/pagesReadPerHour;
        int hoursPerDay = readTime/days;

        System.out.println(hoursPerDay);

    }
}
