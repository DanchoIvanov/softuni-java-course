import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());
        double water = 20;
        double electricity = 0;
        double electricityTotal = 0;
        double internet = 15;
        double others = 0;
        double othersTotal = 0;
        double total = 0;



        for (int i = 1; i <= months ; i++) {
            electricity = Double.parseDouble(scanner.nextLine());
            electricityTotal += electricity;
            others = (water + electricity + internet) * 1.2;
            othersTotal += others;
            total += water + electricity + internet + others;
        }

        System.out.printf("Electricity: %.2f lv%n", electricityTotal);
        System.out.printf("Water: %.2f lv%n", water * months);
        System.out.printf("Internet: %.2f lv%n", internet * months);
        System.out.printf("Other: %.2f lv%n", othersTotal);
        System.out.printf("Average: %.2f lv%n", total / months);
    }
}
