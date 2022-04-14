import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = n -> Arrays.stream(n.split("\\s+"))
                .forEach(s -> System.out.println("Sir " + s));
        printer.accept(scanner.nextLine());
    }
}
