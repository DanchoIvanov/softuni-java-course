import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        LinkedHashMap <Double, Integer> occurrences = new LinkedHashMap<>();

        for (double number : numbers){
            occurrences.putIfAbsent(number, 0);
            occurrences.put(number, occurrences.get(number) + 1);
        }

        occurrences.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
