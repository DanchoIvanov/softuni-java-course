import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci(n));
    }

    static List<Long> fibonacciMemory = new ArrayList<>(Arrays.asList(1l, 1l));

    private static Long fibonacci(int n) {
        if (fibonacciMemory.size() >= n + 1){
            return fibonacciMemory.get(n);
        }

        Long result = fibonacci(n - 1) + fibonacci(n - 2);
        fibonacciMemory.add(result);
        return result;

    }
}
