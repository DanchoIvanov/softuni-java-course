import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(getArraySum(numbers, 0));

    }

    private static int getArraySum(int[] numbers, int startIndex ) {
        int sum = 0;
        if (numbers.length -1 == startIndex) {
            return numbers[numbers.length - 1];
        }
        sum += numbers[startIndex] + getArraySum(numbers, startIndex+1);
        return sum;
    }
}
