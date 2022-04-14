import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while(!input.equals("end")){
            String command = input.split(" ")[0];
            int element = Integer.parseInt(input.split(" ")[1]);
            if (command.equals("Delete")){
                numbers.remove(Integer.valueOf(element));
            } else if (command.equals("Insert")){
                int position = Integer.parseInt(input.split(" ")[2]);
                numbers.add(position,element);
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
