import java.util.Arrays;
import java.util.Comparator;

import java.util.Scanner;


public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Comparator<Integer> comparator = ((n1, n2) -> {
            if (n1 % 2 != 0 && n2 % 2 == 0){
                return 1;
            } else if (n1 % 2 == 0 && n2 % 2 != 0){
                return -1;
            } else {
                return n1.compareTo(n2);
            }
        });

        Arrays.stream(numbers).boxed().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
