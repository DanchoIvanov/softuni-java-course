import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int lowerBound = bounds[0];
        int upperBound = bounds[1];
        String condition = scanner.nextLine();
        IntStream.rangeClosed(lowerBound, upperBound).boxed().filter(getPredicate(condition)).forEach(n -> System.out.print(n + " "));
    }

    public static Predicate<Integer> getPredicate(String condition){
        return condition.equals("even") ? n -> n % 2 ==0 : n -> n % 2 !=0;
    }
}
