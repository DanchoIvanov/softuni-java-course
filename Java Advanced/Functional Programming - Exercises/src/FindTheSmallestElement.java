import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        Function <List<Integer>, Integer> getSmallestElementIndex = e ->{
            int min = e.stream().mapToInt(s -> s).min().orElse(0);
            return e.lastIndexOf(min);
        };

        System.out.println(getSmallestElementIndex.apply(numbers));
    }
}
