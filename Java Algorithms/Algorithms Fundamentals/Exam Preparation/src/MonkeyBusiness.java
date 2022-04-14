import java.util.Arrays;
import java.util.Scanner;

public class MonkeyBusiness {
    public static int[] numbers;
    public static int[] combinations;
    public static int solutionCount = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        numbers = new int[n];
        combinations = new int[n];

        for (int i = 1; i <= n; i++) {
            numbers[i - 1] = i;
        }

        combine(0);
        sb.append("Total Solutions: ").append(solutionCount);
        System.out.println(sb);
    }

    private static void combine(int index) {
        if (index >= combinations.length) {
            if (Arrays.stream(combinations).sum() == 0) {
                solutionCount++;
                printSolution();
            }
        } else {
            combinations[index] = numbers[index];
            combine(index + 1);
            combinations[index] = -numbers[index];
            combine(index + 1);
        }
    }

    private static void printSolution() {
        for (int number : combinations) {
            if (number > 0) {
                sb.append("+").append(number).append(" ");
            } else {
                sb.append(number).append(" ");
            }
        }
        sb.append(System.lineSeparator());
    }
}
