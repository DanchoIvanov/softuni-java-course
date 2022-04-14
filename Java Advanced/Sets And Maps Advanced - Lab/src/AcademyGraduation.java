import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double averageGrade = 0;
            for(double grade : grades){
                averageGrade += grade;
            }
            averageGrade /=grades.length;
            students.put(student, averageGrade);
        }

        students.forEach((s, g)-> System.out.printf("%s is graduated with %s%n",s,g));
    }
}
