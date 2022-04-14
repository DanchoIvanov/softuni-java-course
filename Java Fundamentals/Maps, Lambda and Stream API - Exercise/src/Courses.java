import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!input.equals("end")){
            String courseName = input.split(" : ")[0];
            String student = input.split(" : ")[1];
            courses.putIfAbsent(courseName, new ArrayList<>());
            courses.get(courseName).add(student);
            input = scanner.nextLine();
        }
        courses.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("%s: %d%n",e.getKey(),e.getValue().size());
                    e.getValue().stream()
                            .sorted(String::compareTo)
                            .forEach(student -> System.out.printf("-- %s%n",student));
                });

    }
}
