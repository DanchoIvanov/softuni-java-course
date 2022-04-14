import java.util.Arrays;
import java.util.Scanner;

public class NestedLoopsToRecursion {
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        arr = new int[n];
        recursion(n, 0);
        System.out.println(sb.toString().trim());
    }

    private static void recursion(int n, int index) {
        if (index >= arr.length) {
            generate();
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            recursion(n, index + 1);
        }
    }

    private static void generate() {
        Arrays.stream(arr).forEach(n -> sb.append(n).append(" "));
        sb.append(System.lineSeparator());
    }
}
