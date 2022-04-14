package order_by_age;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while(!input.equals("End")) {
            String name = input.split(" ")[0];
            String ID = input.split(" ")[1];
            int age =  Integer.parseInt(input.split(" ")[2]);
            Person person = new Person(name, ID, age);
            people.add(person);
            input = scanner.nextLine();
        }
        people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
    }
}