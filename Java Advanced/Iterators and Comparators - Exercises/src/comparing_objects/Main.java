package comparing_objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            String town = input.split("\\s+")[2];
            people.add(new Person(name, age, town));
            input = scanner.nextLine();
        }
        int personNumber = Integer.parseInt(scanner.nextLine());
        Person person = people.get(personNumber - 1);
        int matches = 0;
        int mismatches = 0;
        for (Person person1 : people) {
            if (person.compareTo(person1) == 0){
                matches++;
            } else {
                mismatches++;
            }
        }
        if (matches == 1){
            System.out.println("No matches");
        } else {
            System.out.println(matches + " " + mismatches + " " + people.size());
        }
    }
}
