package birthday_celebratoins;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String classType = tokens[0];
            switch (classType){
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    birthables.add(new Citizen(name, age, id, birthDate));
                    break;
                case "Pet":
                    name = tokens[1];
                    birthDate = tokens[2];
                    birthables.add(new Pet(name, birthDate));
                    break;
            }

            input = scanner.nextLine();
        }

        String yearToCheck = scanner.nextLine();
        birthables.stream().map(Birthable::getBirthDate).filter(e-> e.endsWith(yearToCheck)).forEach(System.out::println);
    }
}
