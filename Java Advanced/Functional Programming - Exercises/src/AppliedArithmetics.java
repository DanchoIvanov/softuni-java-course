import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                    numbers = Arrays.stream(numbers).map(n -> n + 1).toArray();
                    break;
                case "multiply":
                    numbers = Arrays.stream(numbers).map(n -> n * 2).toArray();
                    break;
                case "subtract":
                    numbers = Arrays.stream(numbers).map(n -> n - 1).toArray();
                    break;
                case "print":
                    System.out.println(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
