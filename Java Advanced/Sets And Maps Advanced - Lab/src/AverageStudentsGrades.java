import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeMap <String, List<Double>>students = new TreeMap<>();


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String student = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);
            students.putIfAbsent(student, new ArrayList<>());
            students.get(student).add(grade);
        }
        students.forEach((key, value) ->{
            System.out.print(key + " -> ");
            value.forEach(e -> System.out.printf("%.2f ",e));
            double averageGrade = 0;
            for (double grade : value){
                averageGrade += grade;
            }
            averageGrade /= value.size();
            System.out.printf("(avg: %.2f)%n",averageGrade);
        });

    }
}