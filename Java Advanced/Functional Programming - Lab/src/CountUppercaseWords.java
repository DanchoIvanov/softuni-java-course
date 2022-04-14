import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> startsWithCapitalLetter = str -> Character.isUpperCase(str.charAt(0));
        List<String> capitalLetterWords = words.stream().filter(startsWithCapitalLetter).collect(Collectors.toList());
        System.out.println(capitalLetterWords.size());
        capitalLetterWords.forEach(System.out::println);
    }
}
