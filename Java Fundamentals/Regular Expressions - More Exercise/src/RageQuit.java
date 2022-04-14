import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(?<string>\\D+)(?<repeatCount>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder result = new StringBuilder();
        Matcher matcher = pattern.matcher(input);
        List<Character> uniqueCharacters = new ArrayList<>();
        while (matcher.find()){
            String currentMatch = matcher.group("string").toUpperCase();
            int repeatCount = Integer.parseInt(matcher.group("repeatCount"));
            if (repeatCount !=0){
                for (char letter : currentMatch.toCharArray()){
                    if (!uniqueCharacters.contains(letter)){
                        uniqueCharacters.add(letter);
                    }
                }
            }
            result.append(currentMatch.repeat(repeatCount).toUpperCase());
        }
        System.out.println("Unique symbols used: " + uniqueCharacters.size());
        System.out.println(result);
    }
}
