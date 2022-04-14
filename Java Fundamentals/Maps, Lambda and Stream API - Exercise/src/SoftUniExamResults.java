import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> submissionsCount = new TreeMap<>();
        Map<String, Integer> results = new TreeMap<>();
        while(!input.equals("exam finished")){
            String student = input.split("-")[0];
            String language = input.split("-")[1];
            if (!language.equals("banned")){
                int points = Integer.parseInt(input.split("-")[2]);
                submissionsCount.putIfAbsent(language, 0);
                submissionsCount.put(language, submissionsCount.get(language) + 1);
                if (results.containsKey(student)){
                    if (results.get(student) < points && results.get(student) > -1){
                        results.put(student, points);
                    }
                } else {
                    results.put(student, points);
                }
            } else {
                if (results.containsKey(student)) {
                    results.put(student, -1);
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        results.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    if(e.getValue() > -1){
                        System.out.printf("%s | %d%n",e.getKey(),e.getValue());
                    }
                });
        System.out.println("Submissions:");
        submissionsCount.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> System.out.printf("%s - %d%n",e.getKey(), e.getValue()));
    }
}
