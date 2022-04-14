import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream((scanner.nextLine().split("\\s+")))
                .mapToInt(Integer::parseInt).toArray();

        int result = sum(numbers, numbers.length - 1);
        System.out.println(result);
    }

    private static int sum(int[] numbers, int index) {
        if (index < 0){
            return 0;
        }
        int result = numbers[index];
        return result + sum(numbers, index -1);
    }
}
