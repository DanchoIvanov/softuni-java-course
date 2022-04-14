package students_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        while (!input.equals("end")) {
            String firstName = input.split("\\s+")[0];
            String lastName = input.split("\\s+")[1];
            int age = Integer.parseInt(input.split("\\s+")[2]);
            String city = input.split("\\s+")[3];
            if (studentExists(students, firstName, lastName)) {
                Student student = getStudent(students, firstName, lastName);
                assert student != null;
                student.setAge(age);
                student.setHometown(city);
            } else {
                Student student = new Student(firstName, lastName, age, city);
                students.add(student);
            }
            input = scanner.nextLine();
        }
        String city = scanner.nextLine();
        students.forEach(student -> {
            if (student.getHometown().equals(city)) {
                System.out.println(student);
            }
        });
    }

    public static boolean studentExists(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            boolean firstNameExists = student.getFirstName().equals(firstName);
            boolean lastNameExists = student.getLastName().equals(lastName);
            if (firstNameExists && lastNameExists) {
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            boolean firstNameExists = student.getFirstName().equals(firstName);
            boolean lastNameExists = student.getLastName().equals(lastName);
            if (firstNameExists && lastNameExists) {
                return student;
            }
        }
        return null;
    }
}