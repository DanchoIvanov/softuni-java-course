import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("end")){
            String command = input.split(" ")[0];
            if (command.equals("Add")){
                int passenger = Integer.parseInt(input.split(" ")[1]);
                wagons.add(passenger);
            } else {
                int passenger = Integer.parseInt(command);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + passenger <= maxCapacity){
                        wagons.set(i, wagons.get(i) + passenger);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
