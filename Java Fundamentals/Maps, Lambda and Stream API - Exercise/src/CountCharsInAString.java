import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> charEncounters = new LinkedHashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar != ' '){
                charEncounters.putIfAbsent(currentChar, 0);
                charEncounters.put(currentChar, charEncounters.get(currentChar) + 1);
            }
        }
        for (Map.Entry <Character, Integer> entry : charEncounters.entrySet()){
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
