import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double depositAmount = Double.parseDouble(scanner.nextLine());
        int depositLengthMonths = Integer.parseInt(scanner.nextLine());
        double depositYearIncrese = Double.parseDouble(scanner.nextLine()) / 100;

        //сума = депозирана сума + срок на депозита * ((депозирана сума * годишен лихвен процент ) / 12)
        double sum = depositAmount + depositLengthMonths * (( depositAmount * depositYearIncrese ) / 12);

        System.out.printf("%.2f",sum);

    }
}
