import java.util.Scanner;

public class CombinationsWithRepetition {

    private static String[] input;
    private static int k;
    private static String combinations[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        input = scanner.nextLine().split("\\s+");
        k = Integer.parseInt(scanner.nextLine());
        combinations = new String[k];

        combine(0, 0);
    }

    private static void combine(int index, int start) {
        if (index >= k) {
            print(combinations);
            return;
        }

        for (int i = start; i < input.length; i++) {
            combinations[index] = input[i];
            combine(index + 1, i);
        }
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}
