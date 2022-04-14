import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> characterCount = new TreeMap<>();
        String input = scanner.nextLine();
        for (char character : input.toCharArray()){
            characterCount.putIfAbsent(character, 0);
            characterCount.put(character, characterCount.get(character) + 1);
        }
        characterCount.forEach((k,v)-> System.out.printf("%c: %d time/s%n",k,v));
    }
}
