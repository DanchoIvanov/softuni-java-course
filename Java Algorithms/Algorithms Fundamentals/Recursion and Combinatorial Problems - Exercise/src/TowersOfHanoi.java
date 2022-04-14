import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TowersOfHanoi {
    public static StringBuilder out = new StringBuilder();

    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();

    public static int steps = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int disk = Integer.parseInt(scanner.nextLine());

        generateSource(disk);
        printRods();
        solve(disk, source, destination, spare);

        System.out.println(out.toString());
    }

    private static void printResult() {
        System.out.println("Source: " + String.join(", ", (CharSequence) source));
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            out.append("Step #").append(steps++)
                    .append(": Moved disk")
                    .append(System.lineSeparator());
            printRods();
            return;
        }
        solve(disk - 1, source, spare, destination);
        solve(1, source, destination, spare);
        solve(disk - 1, spare, destination, source);
    }


    private static void generateSource(int n) {
        int[] arr = IntStream.rangeClosed(1, n).toArray();
        Arrays.stream(arr).forEach(source::addLast);
    }

    public static void printRods() {
        out.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n",
                        formatRod(source), formatRod(destination), formatRod(spare)))
                .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> stack) {
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
