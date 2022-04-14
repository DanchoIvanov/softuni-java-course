package company_roster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee = new Employee(name, salary, position, department);
            if (input.length == 5) {
                if (input[4].contains("@")) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
            departments.putIfAbsent(department, new Department());
            departments.get(department).getDepartment().add(employee);
        }

        String highestPayedDepartment = departments.entrySet().stream()
                .max(Comparator.comparingDouble(e -> e.getValue().getAverageSalary())).map(Map.Entry::getKey).get();

        System.out.println("Highest Average Salary: " + highestPayedDepartment);
        departments.get(highestPayedDepartment).getDepartment().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(e -> System.out.printf("%s %.2f %s %d%n", e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}
