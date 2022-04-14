import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int i = 1; i <= n ; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            if (maxValue<value){
                maxValue = value;
            }
            if (minValue >value){
                minValue = value;
            }

        }
        System.out.printf("Max number: %d\n" +
                "Min number: %d",maxValue, minValue);
    }
}
