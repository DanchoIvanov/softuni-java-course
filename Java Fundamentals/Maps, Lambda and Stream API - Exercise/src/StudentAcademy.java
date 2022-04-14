import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            students.putIfAbsent(student, new ArrayList<>());
            students.get(student).add(grade);
        }
        students.forEach((key, value) -> {
            double gradesSum = value.stream()
                    .mapToDouble(grade -> grade).sum();
            double averageGrade = gradesSum / value.size();
            value.add(0, averageGrade);
        });
        students.entrySet().stream()
                .filter(e-> e.getValue().get(0) >= 4.5)
                .sorted((e1,e2)-> Double.compare(e2.getValue().get(0), e1.getValue().get(0)))
                .forEach(e-> System.out.printf("%s -> %.2f%n",e.getKey(),e.getValue().get(0)));
    }
}
