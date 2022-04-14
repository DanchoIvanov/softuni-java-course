import java.util.Arrays;
import java.util.Scanner;

public class CombinationsWithRepetition {
    private static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        arr = new int[k];
        combine(0,1, n);
    }

    private static void combine(int index, int start, int end) {
        if (index >= arr.length){
            print();
            return;
        }

        for (int i = start; i <= end ; i++) {
            arr[index] = i;
            combine(index + 1, i, end);
        }
    }

    private static void print() {
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
