import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersForDivision = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Predicate<Integer> predicate = num -> {
            for (int number : numbersForDivision){
                if (num % number != 0){
                    return false;
                }

            }
            return true;
        };

        IntStream.rangeClosed(1, n).boxed().filter(predicate).forEach(e -> System.out.print(e + " "));
    }
}
