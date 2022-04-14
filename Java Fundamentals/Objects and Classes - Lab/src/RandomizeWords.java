import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List <String> words = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        while (words.size()>0){
            Random random = new Random();
            String word = words.get(random.nextInt(words.size()));
            System.out.println(word);
            words.remove(word);
        }
    }
}
