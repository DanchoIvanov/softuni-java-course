import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int divisible = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);
        System.out.println(numbers.stream()
                .filter(n -> n % divisible != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
