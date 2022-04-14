package border_control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> citizens = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
                String name = tokens[0];
                String id = tokens[tokens.length-1];
                if (tokens.length == 2){
                    citizens.add(new Robot(name, id));
                } else if (tokens.length == 3){
                    int age = Integer.parseInt(tokens[1]);
                    citizens.add(new Citizen(name, age, id));
                }
                input = scanner.nextLine();
            }

        String fakeIDNumber = scanner.nextLine();
        citizens.stream().filter(e -> e.getId().endsWith(fakeIDNumber)).forEach(e -> System.out.println(e.getId()));
    }
}
