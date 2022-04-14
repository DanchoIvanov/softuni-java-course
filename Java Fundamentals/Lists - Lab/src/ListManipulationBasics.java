import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String command = input.split(" ") [0];
            switch (command){
                case "Add":
                    int number = Integer.parseInt(input.split(" ")[1]);
                    numbers.add(number);
                    break;
                case "Remove":
                    number = Integer.parseInt(input.split(" ")[1]);
                    numbers.remove(Integer.valueOf(number));
                    break;
                case "RemoveAt":
                    number = Integer.parseInt(input.split(" ")[1]);
                    numbers.remove(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(input.split(" ")[1]);
                    int index = Integer.parseInt(input.split(" ")[2]);
                    numbers.add(index, number);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
