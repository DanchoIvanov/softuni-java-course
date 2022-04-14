import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] evenNumbers = Arrays.stream(numbers).filter(e -> e % 2 == 0).toArray();
        String toPrint = Arrays.stream(evenNumbers).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(toPrint);
        int[] evenNumbersSorted = Arrays.stream(evenNumbers).sorted().toArray();
        toPrint = Arrays.stream(evenNumbersSorted).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(toPrint);
    }
}
