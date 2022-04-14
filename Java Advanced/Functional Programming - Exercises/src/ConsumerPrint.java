import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = n -> {
            Arrays.stream(n.split("\\s+"))
                    .forEach(System.out::println);
        };

        printer.accept(scanner.nextLine());
    }
}
