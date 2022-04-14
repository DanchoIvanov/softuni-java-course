import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while(!input.equals("End")){
            String command = input.split("\\s+")[0];
            switch (command){
                case "Add":
                    int number = Integer.parseInt(input.split("\\s+")[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(input.split("\\s+")[1]);
                    int index = Integer.parseInt(input.split("\\s+")[2]);
                    if(index >= 0 && index < numbers.size()){
                        numbers.add(index, number);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(input.split("\\s+")[1]);
                    if(index >= 0 && index < numbers.size()){
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String option = input.split("\\s+")[1];
                    int count = Integer.parseInt(input.split("\\s+")[2]);
                    switch (option){
                        case "left":
                            for (int i = 0; i < count; i++) {
                                numbers.add(numbers.get(0));
                                numbers.remove(0);
                            }
                            break;
                        case "right":
                            for (int i = 0; i < count; i++) {
                                numbers.add(0, numbers.get(numbers.size()-1));
                                numbers.remove(numbers.size()-1);
                            }
                            break;
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
