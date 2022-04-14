package strategy_pattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> peopleSortedByName = new TreeSet<>(new PersonNameComparator());
        Set<Person> peopleSorterByAge = new TreeSet<>(new PersonAgeComparator());
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            Person person = new Person(name, age);
            peopleSortedByName.add(person);
            peopleSorterByAge.add(person);
        }
        peopleSortedByName.forEach(System.out::println);
        peopleSorterByAge.forEach(System.out::println);
    }
}
