import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String keyRegex = "[starSTAR]";
        Pattern keyPattern = Pattern.compile(keyRegex);
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher keyMatcher = keyPattern.matcher(input);
            int keyDecrease = 0;
            while (keyMatcher.find()){
                keyDecrease++;
            }
            StringBuilder decryptedMessage = new StringBuilder();
            for (char character : input.toCharArray()){
                decryptedMessage.append((char)(character-keyDecrease));
            }
            String regex = "@(?<planet>[A-Za-z]+)[^@\\-!:]*?:(?<population>\\d+)[^@\\-!:]*?!(?<attackType>[AD])![^@\\-!:]*?->(?<soldierCount>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage.toString());
            if (matcher.find()){
                String planet = matcher.group("planet");
                String attackType = matcher.group("attackType");
                if(attackType.equals("A")){
                    attacked.add(planet);
                } else {
                    destroyed.add(planet);
                }
            }
        }
        System.out.println("Attacked planets: " + attacked.size());
        attacked.stream()
                .sorted(String::compareTo)
                .forEach(e-> System.out.println("-> "+ e));
        System.out.println("Destroyed planets: " + destroyed.size());
        destroyed.stream()
                .sorted(String::compareTo)
                .forEach(e-> System.out.println("-> "+ e));
    }
}
