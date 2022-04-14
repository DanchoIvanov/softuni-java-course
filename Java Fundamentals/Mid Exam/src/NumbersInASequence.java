import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumbersInASequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Finish")){
            String command = input.split("\\s+")[0];
            int value = Integer.parseInt(input.split("\\s+")[1]);
            switch (command){
                case "Add":
                    numbers.add(value);
                    break;
                case "Remove":
                    numbers.remove(Integer.valueOf(value));
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(input.split("\\s+")[2]);
                    int index = numbers.indexOf(value);
                    numbers.set (index, replacement);
                    break;
                case "Collapse":
                    numbers.removeIf(n -> (n < value));
                    break;
            }

            input = scanner.nextLine();
        }
        for (int elemenet:numbers) {
            System.out.printf("%d ", elemenet);
        }
    }
}
