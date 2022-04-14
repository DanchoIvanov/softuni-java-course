package multiple_implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyers = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            if (input.length == 3){
                String group = input[2];
                buyers.put(name, new Rebel(name, age, group));
            } else if (input.length == 4){
                String id = input[2];
                String birthDate = input[3];
                buyers.put(name, new Citizen(name, age, id, birthDate));
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("End")){
            if (buyers.containsKey(input)){
                buyers.get(input).buyFood();
            }
            input = scanner.nextLine();
        }
        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}
