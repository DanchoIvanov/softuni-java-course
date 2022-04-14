import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int intervalStart = Integer.parseInt(scanner.nextLine());
        int intervalEnd = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());
        int combinationsCount = 0;

        for (int x1 = intervalStart; x1 <= intervalEnd; x1++) {
            for (int x2 = intervalStart; x2 <= intervalEnd; x2++) {
                combinationsCount++;
                int result = x1 + x2;
                if (result == magicNumber) {
                    System.out.printf("Combination N:%d (%d + %d = %d)", combinationsCount, x1, x2, magicNumber);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", combinationsCount, magicNumber);
    }
}
