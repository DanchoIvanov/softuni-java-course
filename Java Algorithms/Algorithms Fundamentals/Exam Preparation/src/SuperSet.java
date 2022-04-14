import java.util.Arrays;
import java.util.Scanner;

public class SuperSet {
    public static int[] numbers;
    public static int[] result;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 1; i <= numbers.length; i++) {
            result = new int[i];

            combine(0, 0, i);
        }

        System.out.println(sb.toString().trim());
    }

    private static void combine(int index, int start, int limit) {
        if (index >= limit) {
            print();
            return;
        }

        for (int i = start; i < numbers.length; i++) {
            result[index] = numbers[i];
            combine(index + 1, i + 1, limit);
        }
    }

    private static void print() {
        for (int number : result) {
            sb.append(number).append(" ");
        }
        sb.append(System.lineSeparator());
    }
}
