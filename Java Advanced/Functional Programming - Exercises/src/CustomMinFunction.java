import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;


public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> getMinInt = n -> Arrays.stream(n)
                .min()
                .orElse(0);

        System.out.println(getMinInt.apply(numbers));
    }
}
