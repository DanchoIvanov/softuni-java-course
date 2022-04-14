import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(scanner.nextLine());
        int daysTillDeadline = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());

        double workHours = 0.9*daysTillDeadline*8;
        int overtime = workers*2*daysTillDeadline;
        double totalWorkHours = Math.floor(workHours+overtime);
        double difference = Math.abs(totalWorkHours-hoursNeeded);

        if (totalWorkHours>=hoursNeeded){
            System.out.printf("Yes!%.0f hours left.",difference);
        }
        else
            System.out.printf("Not enough time!%.0f hours needed.",difference);
    }
}
