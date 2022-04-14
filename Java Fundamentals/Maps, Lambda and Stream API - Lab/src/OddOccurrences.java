import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();

        for (String word:words){
            String wordToLowerCase = word.toLowerCase();
            counts.putIfAbsent(wordToLowerCase, 0);
            counts.put(wordToLowerCase, counts.get(wordToLowerCase) +1);
        }
        ArrayList<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()){
            if (entry.getValue() % 2 ==1){
                odds.add(entry.getKey());
            }
        }
        System.out.println(odds.stream().collect(Collectors.joining(", ")));
    }
}
