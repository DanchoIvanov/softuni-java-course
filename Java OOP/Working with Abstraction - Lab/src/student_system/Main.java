package student_system;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input = scanner.nextLine();
        while (!input.equals("Exit")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String name = tokens[1];

            switch (command){
                case "Create":
                    int age = Integer.parseInt(tokens[2]);
                    double grade = Double.parseDouble(tokens[3]);
                    studentSystem.create(name, age, grade);
                    break;
                case "Show":
                    studentSystem.show(name);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
