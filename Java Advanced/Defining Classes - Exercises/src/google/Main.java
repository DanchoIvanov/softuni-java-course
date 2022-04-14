package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] command = input.split("\\s+");
            String personName = command[0];
            String subClass = command[1];
            people.putIfAbsent(personName, new Person(personName));
            switch (subClass){
                case "company":
                    String companyName = command[2];
                    String department = command[3];
                    double salary = Double.parseDouble(command[4]);
                    people.get(personName).setCompany(new Company(companyName, department, salary));
                    break;
                case "pokemon":
                    String pokemonName = command[2];
                    String pokemonType = command[3];
                    people.get(personName).getPokemons().add(new Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String name = command[2];
                    String birthday = command[3];
                    people.get(personName).getParents().add(new Parents(name, birthday));
                    break;
                case "children":
                    name = command[2];
                    birthday = command[3];
                    people.get(personName).getChildren().add(new Children(name, birthday));
                    break;
                case "car":
                    String model = command[2];
                    int speed = Integer.parseInt(command[3]);
                    people.get(personName).setCar(new Car(model, speed));
                    break;
            }
            input = scanner.nextLine();
        }
        String personName = scanner.nextLine();
        Person person = people.get(personName);
        System.out.println(person.getName());
        System.out.println("Company:");
        if (person.getCompany()!=(null)){
            System.out.printf("%s %s %.2f%n",person.getCompany().getName(), person.getCompany().getDepartment(), person.getCompany().getSalary());
        }
        System.out.println("Car:");
        if (person.getCar() != null){
            System.out.printf("%s %d%n", person.getCar().getModel(), person.getCar().getSpeed());
        }
        System.out.println("Pokemon:");
        if (!person.getPokemons().isEmpty()){
            person.getPokemons().forEach(p -> System.out.printf("%s %s%n", p.getName(), p.getType()));
        }
        System.out.println("Parents:");
        if (!person.getParents().isEmpty()){
            person.getParents().forEach(p -> System.out.printf("%s %s%n", p.getName(), p.getBirthday()));
        }
        System.out.println("Children:");
        if (!person.getParents().isEmpty()){
            person.getChildren().forEach(p -> System.out.printf("%s %s%n", p.getName(), p.getBirthday()));
        }
    }
}
