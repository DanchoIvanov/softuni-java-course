import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static int[] elements;
    public static int[] reversed;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        reversed = new int[elements.length];
        reverse(0, elements.length - 1);
        print(reversed);
    }

    private static void print(int[] reversed) {
        Arrays.stream(reversed).forEach(n -> System.out.print(n + " "));
    }

    private static void reverse(int index, int end) {
        if (index >= reversed.length) {
            return;
        }

        reversed[end] = elements[index];
        reverse(index + 1, end - 1);
    }
}
