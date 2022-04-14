package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("Beast!")){
            String[] information = scanner.nextLine().split("\\s+");
            String name = information[0];
            int age = Integer.parseInt(information[1]);
            String gender = information[2];
            try {
                switch (input) {
                    case "Dog":
                            Dog dog = new Dog(name, age, gender);
                            System.out.println(dog);
                            break;
                    case "Cat":
                            Cat cat = new Cat(name, age, gender);
                            System.out.println(cat);
                            break;
                    case "Frog":
                            Frog frog = new Frog(name, age, gender);
                            System.out.println(frog);
                            break;
                    case "Kittens":
                             Kitten kitten = new Kitten(name, age);
                            System.out.println(kitten);
                            break;
                    case "Tomcat":
                            Tomcat tomcat = new Tomcat(name, age);
                            System.out.println(tomcat);
                            break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }
    }
}
