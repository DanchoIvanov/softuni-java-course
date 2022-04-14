import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String namePattern = "@(?<name>[A-Za-z]*)\\|";
        String agePattern = "#(?<age>[1-9][0-9]*)\\*";
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern name = Pattern.compile(namePattern);
            Pattern age = Pattern.compile(agePattern);
            Matcher names = name.matcher(input);
            Matcher ages = age.matcher(input);
            List<String> namesList = new ArrayList<>();
            List<String> agesList = new ArrayList<>();
            while (names.find()){
                namesList.add(names.group("name"));
            }
            while (ages.find()){
                agesList.add(ages.group("age"));
            }
            if (!namesList.isEmpty() && !agesList.isEmpty()) {
                for (String person : namesList) {
                    for (String year : agesList) {
                        System.out.printf("%s is %s years old.%n", person, year);
                    }
                }
            }
        }
    }
}

