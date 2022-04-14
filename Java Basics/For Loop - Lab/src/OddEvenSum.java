import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0){
                evenSum = evenSum + value;
            }
            else
                oddSum = oddSum + value;
        }
        int difference = Math.abs(oddSum - evenSum);

        if (oddSum == evenSum){
            System.out.printf("Yes\n" +
                    "Sum = %d",oddSum);
        }
        else

            System.out.printf("No\n" +
                    "Diff = %d",difference);
    }
}
