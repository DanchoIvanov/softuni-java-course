import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<String>> employersList = new LinkedHashMap<>();
        while(!input.equals("End")){
            String companyName = input.split(" -> ")[0];
            String employeeID = input.split(" -> ")[1];
            employersList.putIfAbsent(companyName, new ArrayList<>());
            if (!employersList.get(companyName).contains(employeeID)){
                employersList.get(companyName).add(employeeID);
            }
            input = scanner.nextLine();
        }
        employersList.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> {
                    System.out.printf("%s%n",e.getKey());
                    e.getValue().forEach(employee -> System.out.println("-- " + employee));
                });
    }
}
