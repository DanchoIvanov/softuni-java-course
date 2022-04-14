import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int num = Integer.parseInt(scanner.nextLine());
        if (num <= 7 && num >= 1){
            System.out.println(days[num - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
